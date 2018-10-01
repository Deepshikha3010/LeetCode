class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
            
        int start = 0, end = nums.length - 1;
        int last = nums[end];
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (target <= last) {
                if (nums[mid] < target || nums[mid] > last) {
                    start = mid;
                } else {
                    end = mid;
                }
            } else {
                if (nums[mid] > target || nums[mid] < last) {
                    end = mid;
                } else {
                    start = mid;
                }
            }
        }
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }
}