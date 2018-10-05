class Solution {
    int len = 0;
    
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] map = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            helper(map, cur);
        }
        return len;
    }
    
    private void helper(int[] nums, int cur) {
        if (len == 0) {
            nums[0] = cur;
            len++;
            return;
        }
        int start = 0, end = len - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < cur) {
                start = mid;
            } else if (nums[mid] > cur) {
                end = mid;
            } else {
                return;
            }
        }
        if (cur <= nums[start]) {
            nums[start] = cur;
        } else if (nums[start] < cur && cur <= nums[end]) {
            nums[end] = cur;
        } else {
            nums[end + 1] = cur;
            len++;
        }
    }
}