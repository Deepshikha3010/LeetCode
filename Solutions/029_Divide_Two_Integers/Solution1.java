/**
 * Type: Binary Search
 * Time: logn
 * Space: 1
 */
class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) return Integer.MAX_VALUE;
            else if (divisor == 1) return Integer.MIN_VALUE;
        }
        
        boolean isNegative = false;
        
        if (dividend < 0 && divisor < 0) isNegative = false;
        else if (dividend < 0 || divisor < 0) isNegative = true;
        
        long divd = Math.abs((long) dividend);
        long divs = Math.abs((long) divisor);
        
        int res = 0;
        while (divd >= divs) {
            int shift  = 0;
            while ((divs << shift) <= divd) {
                shift++;
            }
            res += 1 << (shift - 1);
            divd -= divs << (shift - 1);
        }
        
        return isNegative ? -res : res;
    }
}