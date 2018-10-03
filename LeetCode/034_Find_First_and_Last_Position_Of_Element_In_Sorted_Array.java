class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        if (nums == null || nums.length == 0) {
            Arrays.fill(result, -1);
            return result;
        }
        result[0] = helper(nums, target, true);
        result[1] = helper(nums, target, false);
        return result;
    }
    
    private int helper(int[] nums, int target, boolean isLeft) {
        int start = 0, end = nums.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                if (isLeft) {
                    end = mid;
                } else {
                    start = mid;
                }
            }
        }
        if (isLeft) {
            if (nums[start] == target) {
                return start;   
            }
            if (nums[end] == target) {
                return end;
            }
        } else {
            if (nums[end] == target) {
                return end;
            }
            if (nums[start] == target) {
                return start;   
            }
        }
        return -1;
    }
}