class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        for (int i = 0; i < nums.length; i++) {
            int cur = Math.abs(nums[i]);
            nums[cur - 1] = -Math.abs(nums[cur - 1]);
        }
        
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (cur > 0) {
                res.add(i + 1);
            }
        }
        
        return res;
    }
}