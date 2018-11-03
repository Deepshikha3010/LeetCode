class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        
        k = k % nums.length;
        
        int start = 0, end = nums.length - k - 1;
        reverse(nums, start, end);
        
        start = nums.length - k;
        end = nums.length - 1;
        reverse(nums, start, end);
        
        start = 0;
        end = nums.length - 1;
        reverse(nums, start, end);
    }
    
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    
    private void swap(int[] nums, int start, int end) {
        int tmp = nums[start];
        nums[start] = nums[end];
        nums[end] = tmp;
    }
}