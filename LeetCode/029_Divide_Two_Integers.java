class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int sign = 1;
        int result = 0;
        long divid = (long) dividend;
        long divis = (long) divisor;
        if (divid < 0) {
            divid = -divid;
            sign = -sign;
        }
        if (divis < 0) {
            divis = -divis;
            sign = -sign;
        }
        while(divid >= divis) {
            int shift = 0;
            while(divid >= (divis << shift)) {
                shift++;
            }
            result += 1 << (shift - 1);
            divid -= divis << (shift - 1);
        }
        return result * sign;
    }
}