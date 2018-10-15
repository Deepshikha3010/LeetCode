class Solution {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        
        boolean increase = true;
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            int pre = nums[i - 1];
            if (increase && cur < pre) {
                if (cur < pre) {
                    swap(nums, i - 1, i);
                }
            } else {
                if (cur > pre) {
                    swap(nums, i - 1, i);
                }
            }
            increase = !increase;
        }
    }
    
    private void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}