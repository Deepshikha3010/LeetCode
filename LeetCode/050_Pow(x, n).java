class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        boolean isNegative = false;
        if (n <= 0) {
            x = 1/x;
            isNegative = true;
            n = -(n + 1);
        }
        double result = 1, temp = x;
        while(n != 0) {
            if (n % 2 == 1) {
                result *= temp;
            }
            temp *= temp;
            n /= 2;
        }
        return isNegative ? result * x : result;
    }
}