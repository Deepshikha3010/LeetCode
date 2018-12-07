// https://www.youtube.com/watch?v=DqhPJ8MzDKM

/**
 * f[i][j]: If the source to current length i matches the pattern to current length j;
 * f[0][0] = true: When both are empty string, they are matched; 
 * 
 * For the empty string of source, check if pattern matches the source
 *      - If current char is *, we check if the char before the previous char in both string match.
 * 
 * For .: Check if previous length are match
 *      - ab
 *      - a.
 * 
 * For same letter: Check if previous length are match
 *      - ab
 *      - ab
 * 
 * For *: Check previous char of pattern match current char of source
 *      1. If previous char in pattern doesn't match, means we should delete it, check the length before previous char in both
 *          a    i 
 *          ab*  j - 2
 *      2. If previous char in pattern match, means we may still delete it, or we check we have already approved them at the previous length in source.
 *          ab   i
 *          abb* j - 2
 *          ----------
 *          ab   i
 *          ab*  j - 1
 * 
 *          abb i - 1
 *          ab*  j
 */
class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        
        boolean[][] f = new boolean[s.length() + 1][p.length() + 1];
        
        f[0][0] = true;
        for (int i = 1; i <= p.length(); i++) {
            if (p.charAt(i - 1) == '*') {
                f[0][i] = f[0][i - 2];
            }
        }
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    f[i][j] = f[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    if (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.') {
                        f[i][j] = f[i][j - 2] || f[i - 1][j];
                    } else {
                        f[i][j] = f[i][j - 2];
                    }
                }
            }
        }
        
        return f[s.length()][p.length()];
    }
}