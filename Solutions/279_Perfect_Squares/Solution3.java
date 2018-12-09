/**
 * Type: Math
 * Time: 1
 * Space: 1
 */
class Solution {
    public int numSquares(int n) {
        if (n <= 0) {
            return 0;
        }
        
        while (n % 4 == 0) {
            n /= 4;
        }
        
        if (n % 8 == 7) {
            return 4;
        }
        
        // 1 or 2
        for (int i = 0; i * i <= n; i++) {
            int j = (int)Math.sqrt(n - i * i);
            if (j * j + i * i == n) {
                int res = 0;
                if (j > 0) res++;
                if (i > 0) res++;
                return res;
            }
        }
        
        return 3;
    }
}