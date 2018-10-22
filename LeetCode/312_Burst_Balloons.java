class Solution {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] coins = new int[nums.length + 2];
        int n = 1;
            
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                coins[n++] = nums[i];
            }
        }
        coins[0] = coins[n++] = 1;
        int[][] f = new int[n][n];
        
        for (int dis = 2; dis < n; dis++) {
            for (int left = 0; left + dis < n; left++) {
                int right = left + dis;
                for (int i = left + 1; i < right; i++) {
                    f[left][right] = Math.max(coins[left] * coins[i] * coins[right] + f[left][i] + f[i][right], f[left][right]);
                }
            }
        }
        
        return f[0][n - 1];
    }
}