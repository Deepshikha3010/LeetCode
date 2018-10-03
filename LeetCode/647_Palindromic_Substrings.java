class Solution {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int result = 0;
        int len = s.length();
        boolean[][] f = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            f[i][i] = true;
            result++;
            if (i > 0 && s.charAt(i - 1) == s.charAt(i)) {
                f[i - 1][i] = true;
                result++;
            }
        }
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j + 1 < i; j++) {
                if (s.charAt(i) == s.charAt(j) && f[j + 1][i - 1]) {
                    f[j][i] = true;
                    result++;
                }
            }
        }
        return result;
    }
}