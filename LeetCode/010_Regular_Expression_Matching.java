// https://www.youtube.com/watch?v=DqhPJ8MzDKM
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