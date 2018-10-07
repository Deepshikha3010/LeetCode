// time: n && space: n
class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        
        int len = s.length();
        int[] f = new int[len + 1];
        f[0] = 1;
        f[1] = 1;
        
        for (int i = 2; i <= len; i++) {
            int cur = s.charAt(i - 1) - '0';
            int pre = s.charAt(i - 2) - '0';
            f[i] = 0;
            if (cur != 0) {
                f[i] += f[i - 1];
            }
            if (pre == 1 || pre == 2 && cur < 7) {
                f[i] += f[i - 2];
            }
        }
        return f[len];
    }
}