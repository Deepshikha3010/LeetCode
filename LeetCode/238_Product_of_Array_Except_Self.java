class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        
        int[] res = new int[len];
        
        int pre = 1;
        for (int i = 0; i < len; i++) {
            int cur = nums[i];
            res[i] = pre;
            pre *= cur;
        }
        
        int post = 1;
        for (int i = len - 1; i >=0; i--) {
            int cur = nums[i];
            res[i] *= post;
            post *= cur;
        }
        
        return res;
    }
}