// rolling array. space: 1
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        if (nums.length == 1) {
            return nums[0];
        }
        
        int[] f = new int[2];
        f[0] = 0;
        f[1] = nums[0];
        
        for (int i = 2; i < nums.length + 1; i++) {
            f[i % 2] = Math.max(f[(i - 2) % 2] + nums[i - 1], f[(i - 1) % 2]);
        }
        
        return f[nums.length % 2];
    }
}

// space: n
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        if (nums.length == 1) {
            return nums[0];
        }
        
        int[] f = new int[nums.length + 1];
        f[0] = 0;
        f[1] = nums[0];
        
        for (int i = 2; i < nums.length + 1; i++) {
            f[i] = Math.max(f[i - 2] + nums[i - 1], f[i - 1]);
        }
        
        return f[nums.length];
    }
}