/**
http://www.cnblogs.com/grandyang/p/4800552.html
 */

// DP: n * sqrt n
class Solution {
    public int numSquares(int n) {
        if (n < 0) {
            return 0;
        }
        
        int[] f = new int[n + 1];
        Arrays.fill(f, Integer.MAX_VALUE);
        
        for (int i = 0; i * i <= n; i++) {
            f[i * i] = 1;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; i + j * j <= n; j++) {
                f[i + j * j] = Math.min(f[i] + 1, f[i + j * j]);
            }
        }
        
        return f[n];
    }
}

// Math
class Solution {
    public int numSquares(int n) {
        if (n < 0) {
            return 0;
        }
        
        while (n % 4 == 0) {
            n /= 4;
        }
        
        if (n % 8 == 7) {
            return 4;
        }
        
        for (int i = 0; i * i <= n; i++) {
            int j = (int)Math.sqrt(n - i * i);
            if (i * i + j * j == n) {
                int res = 0;
                if (i > 0) {
                    res++;
                }
                if (j > 0) {
                    res++;
                }
                return res;
            }
        }
        
        return 3;
    }
}