/**
 * Type: Math
 * Time: n
 * Space: 1
 */
class Solution {
    public boolean isNumber(String s) {
        if (s == null) return false;
        
        // Delete leading or tailing whitespaces
        s = s.trim();
        if (s.length() == 0) return false;
        
        int i = 0;
        int n = s.length();
        
        // Only the first character can be '-' or '+'
        if (s.charAt(0) == '-' || s.charAt(0) == '+') i++;
        
        // There is no digit at front
        boolean isDigit = false;
        
        // Pass all digits before the '.'
        while (i < n && Character.isDigit(s.charAt(i))) {
            isDigit = true;
            i++;
        }
        
        // Check digits after '.' - ".3" is valid
        if (i < n && s.charAt(i) == '.') {
            i++;
            while (i < n && Character.isDigit(s.charAt(i))) {
                isDigit = true;
                i++;
            }
        }
        
        // there should be digit(s) before 'e'
        if (i < n && s.charAt(i) == 'e' && isDigit) {
            isDigit = false;
            i++;
            if (i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) i++;
            while (i < n && Character.isDigit(s.charAt(i))) {
                isDigit = true;
                i++;
            }
        }
        
        return isDigit && i == n;
    }
}