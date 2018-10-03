/**
3 pointers:
numbers in the left side of head should be 0;
numbers in the right side of tail should be 2;
numbers in the left side of i must not be 2, so when nums[i] == 0 or 1, i increase 1 after swaping.
 */

class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int head = 0, tail = nums.length - 1;
        int i = 0;
        while(i <= tail) {
            if (nums[i] == 0) {
                swap(nums, i, head);
                head++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, tail);
                tail--;
            } else {
                i++;
            }
        }
    }
    
    private void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}