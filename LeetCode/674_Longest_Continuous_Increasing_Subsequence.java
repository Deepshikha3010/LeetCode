class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int max = 1;
        int curMax = 1;
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            if (nums[i] > nums[i - 1]) {
                curMax++;
                max = Math.max(curMax, max);
            } else {
                curMax = 1;
            }
        }
        
        return max;
    }
}