class Solution {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= (i + 1) ^ nums[i];
        }
        
        return res;
    }
}