class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] f = new int[cost.length];
        f[0] = cost[0];
        f[1] = cost[1];
        
        int len = cost.length;
        
        for (int i = 2; i < len; i++) {
            f[i] = Math.min(f[i - 2], f[i - 1]) + cost[i];
        }
        
        return Math.min(f[len - 1], f[len - 2]);
    }
}