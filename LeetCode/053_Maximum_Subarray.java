// space: n
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
        int min = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int cur = sums[i];
            max = Math.max(cur - min, max);
            min = Math.min(cur, min);
        }
        return max;
    }
}

// space: 1
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int max = nums[0];
        int curMax = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            int nextMax = curMax + cur;
            curMax = Math.max(cur, nextMax);
            max = Math.max(curMax, max);
        }
        
        return max;
    }
}