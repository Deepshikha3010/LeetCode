// 2D array DP (Memory Exceed)
class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int len = nums.length;
        long[][] f = new long[len][len];
        
        long max = (long) Integer.MIN_VALUE;
        
        for (int i = 0; i < len; i++) {
            f[i][i] = (long) nums[i];
            max = Math.max(max, f[i][i]);
            for (int j = 0; j < i; j++) {
                f[j][i] = f[j][i - 1] * (long) nums[i];
                max = Math.max(max, f[j][i]);
            }
        }
        
        if (max < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        if (max > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) max;
    }
}

// o(n)
class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int len = nums.length;
        int max = nums[0];
        int curMax = nums[0];
        int curMin = nums[0];
        
        for (int i = 1; i < len; i++) {
            int cur = nums[i];
            int nextMax = curMax * cur;
            int nextMin = curMin * cur;
            curMax = Math.max(cur, Math.max(nextMax, nextMin));
            curMin = Math.min(cur, Math.min(nextMax, nextMin));
            max = Math.max(curMax, max);
        }
        
        return max;
    }
}
