class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        
        int len = nums.length;
        
        for (int i = 0; i < len; i++) {
            if (nums[i] <= 0) {
                nums[i] = Integer.MAX_VALUE;
            }
        }
        
        for (int i = 0; i < len; i++) {
            int cur = Math.abs(nums[i]);
            if (cur <= len) {
                nums[cur - 1] = -(Math.abs(nums[cur - 1]));
            }
        }
        
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        
        return len != Integer.MAX_VALUE ? len + 1 : Integer.MAX_VALUE;
    }
}