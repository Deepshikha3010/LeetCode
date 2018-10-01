class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        helper(nums, new boolean[nums.length], new ArrayList<>(), result);
        return result;
    }
    
    private void helper(int[] nums, boolean[] set, List<Integer> record, List<List<Integer>> result) {
        if (record.size() == nums.length) {
            result.add(new ArrayList<>(record));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (set[i]) {
                continue;
            }
            int cur = nums[i];
            if (i != 0 && nums[i] == nums[i - 1] && !set[i - 1]) {
                continue;
            }
            set[i] = true;
            record.add(cur);
            helper(nums, set, record, result);
            set[i] = false;
            record.remove(record.size() - 1);
        }
    }
}