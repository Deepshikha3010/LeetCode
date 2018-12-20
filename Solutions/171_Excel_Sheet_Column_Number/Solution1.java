/**
 * Type: Math
 * Time: n
 * Space: 1
 */
class Solution {
    public int titleToNumber(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int index = 0;
        int n = s.length() - 1;
        int count = 0;
        while (n - index >= 0) {
            char c = s.charAt(n - index);
            int base = (int)(Math.pow(26, index));
            int d = base * (c + 1 - 'A');
            count += d;
            index++;
        }
        
        return count;
    }
}