/**
 * Sequence DP
 * 
 * Solution 1: 时间复杂度n, 空间复杂度1
 * 1. 创建dis记录能到达最远距离。
 * 2. 遍历nums，将nums[i] + i与dis对比判定，取最大值。
 * 3. 判定dis是否大于等于nums的最高位序。
 * 
 * Solution 2（DP）: 时间复杂度n2, 空间复杂度n
 * 注意：每次判定之前的序位能否到达当前序位。
 */

/**Solution 3 */
class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        
        int range = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            range = Math.max(range, cur + i);
            if (i != nums.length - 1 && range <= i) {
                return false;
            }
        }
        
        return true;
    }
}

 /**Solution 1 */
 class Solution {
    public boolean canJump(int[] nums) {
        int dis = 0;
        for(int i = 0; i < nums.length; i++){
            if(i <= dis){
                dis = Math.max(nums[i] + i, dis);
            }
        }
        return dis >= nums.length - 1;
    }
}

/**Solution 2 */
class Solution {
    public boolean canJump(int[] nums) {
        boolean[] f = new boolean[nums.length];
        f[0] = true;
        
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(f[j] && nums[j] + j >= i){
                    f[i] = true;
                    break;
                }
            }
        }
        return f[nums.length - 1];
    }
}