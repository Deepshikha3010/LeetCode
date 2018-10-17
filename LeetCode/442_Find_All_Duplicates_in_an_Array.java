// Use negative number and index to mark existing number
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        for (int i = 0; i < nums.length; i++) {
            int cur = Math.abs(nums[i]);
            if (nums[cur - 1] < 0) {
                res.add(cur);
            }
            nums[cur - 1] = -Math.abs(nums[cur - 1]);
        }
        
        return res;
    }
}