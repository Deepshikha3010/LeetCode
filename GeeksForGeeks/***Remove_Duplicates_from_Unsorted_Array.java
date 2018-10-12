class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        int index = 0;
        int len = 0;
        while(index < nums.length) {
            int cur = nums[index];
            if (!set.contains(cur)) {
                set.add(cur);
                nums[len] = cur;
            }
            index++;
        }

        return len + 1;
    }
}