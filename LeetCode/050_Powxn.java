class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        
        if (x == 0) {
            return 0;
        }
        
        boolean isNegative = false;
        if (n < 0) {
            x = 1 / x;
            isNegative = true;
            n = - (n + 1);
        }
        
        double result = 1, temp = x;
        while (n != 0) {
            if (n % 2 == 1) {
                result *= temp;
            }
            n /= 2;
            temp *= temp;
        }
        
        return isNegative ? x * result : result;
    }
}