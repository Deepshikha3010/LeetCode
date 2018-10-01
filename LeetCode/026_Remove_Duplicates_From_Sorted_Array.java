class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int head = 0, tail = 0;
        while(tail < nums.length) {
            while(tail < nums.length && nums[head] == nums[tail]) {
                tail++;
            }
            if (tail < nums.length) {
                head++;
                nums[head] = nums[tail];
            }
        }
        return head + 1;
    }
}