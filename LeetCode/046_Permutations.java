class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        helper(nums, new HashSet<>(), result, new ArrayList<>());
        return result;
    }
    
    private void helper(int[] nums, Set<Integer> set, List<List<Integer>> result, List<Integer> record) {
        if (record.size() == nums.length) {
            result.add(new ArrayList<>(record));
        }
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (set.contains(cur)) {
                continue;
            }
            set.add(cur);
            record.add(cur);
            helper(nums, set, result, record);
            set.remove(cur);
            record.remove(record.size() - 1);
        }
    }
}