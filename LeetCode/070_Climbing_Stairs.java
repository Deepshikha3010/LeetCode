/**
 * Sequence DP: f[i]表示第i个位置的状态。
 * 注意：初始化f[0]，f[1]。所以f长度为n + 1
 * 
 */

class Solution {
    public int climbStairs(int n) {
        int[] f = new int[n + 1];
        f[0] = 1;
        f[1] = 1;
        for(int i = 2; i <= n; i++){
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }
}