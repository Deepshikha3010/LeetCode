public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: an integer
     * @return: an integer
     */
    public int twoSum5(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        Arrays.sort(nums);
        
        int res = 0;
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int cur = nums[start] + nums[end];
            if (cur <= target) {
                res += end - start;
                start++;
            } else {
                end--;
            }
        }
        
        return res;
    }
}