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
        
        for (int i = 2; i < nums.length; i++) {
            f[i] = Math.max(f[i - 2] + nums[i - 1], f[i - 1]);
        }
        int max = f[nums.length - 1];
        
        Arrays.fill(f, 0);
        f[1] = 0;
        f[2] = nums[1];
        
        for (int i = 3; i < nums.length + 1; i++) {
            f[i] = Math.max(f[i - 2] + nums[i - 1], f[i - 1]);
        }
        max = Math.max(max, f[nums.length]);
        
        return max;
    }
}