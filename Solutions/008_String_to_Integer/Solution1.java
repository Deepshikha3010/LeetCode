/**
 * Type: Math
 * Time: n
 * Space: n
 */
class Solution {
    public int myAtoi(String str) {
        if (str == null) return 0;
        
        str = str.trim();
        if (str.length() == 0) return 0;
        
        boolean isNegative = false;
        long num = 0;
        
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i == 0) {
                if ((c == '-' || c == '+')) {
                    isNegative = c == '-';
                    continue;
                }
                if (c == '0') continue;
            }
            
            if (!Character.isDigit(c)) break;
            long temp = num * 10 + c - '0';
            if (temp > Integer.MAX_VALUE) return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            num = temp;
        }
        
        if (num == 0) return 0;
        return isNegative ? (int)(-num) : (int)num;
    }
}