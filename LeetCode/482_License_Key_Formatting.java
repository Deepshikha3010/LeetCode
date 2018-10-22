class Solution {
    public String licenseKeyFormatting(String S, int K) {
        if (S == null || S.length() == 0) {
            return S;
        }
        int dashNum = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '-') {
                dashNum++;
            }
        }
        
        int len = S.length() - dashNum;
        if (len == 0) {
            return "";
        }
        int first = len % K;
        
        StringBuilder sb = new StringBuilder();
        int n = -first;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '-') {
                continue;
            }
            if (!Character.isDigit(c)) {
                c = Character.toUpperCase(c);
            }
            sb.append(c);
            n++;
            if (n == 0 || n == K) {
                sb.append('-');
                n = 0;
            }
        }
        
        return sb.substring(0, sb.length() - 1).toString();
    }
}