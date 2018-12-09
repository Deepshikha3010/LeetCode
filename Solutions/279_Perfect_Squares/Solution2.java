/**
 * Type: Dynamic Programming
 * Time: n*sqrt(n)
 * Space: n
 */
class Solution {
    public int numSquares(int n) {
        if (n <= 0) {
            return 0;
        }
        
        // f[i] repesents the least number of perfect square numbers of i.
        int[] f = new int[n + 1];
        Arrays.fill(f, Integer.MAX_VALUE);
        
        for (int i = 0; i * i <= n; i++) {
            f[i * i] = 1;
        }
        
        for (int i = 0; i <= n; i++) {
            for (int j = 1; i + j * j <= n; j++) {
                // From i to i + j * j, should be 1 more perfect number.
                f[i + j * j] = Math.min(f[i + j * j], f[i] + 1);
            }
        }
        
        return f[n];
    }
}