class Solution {
    int max;
    int curMax;
    
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        
        max = 0;
        
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (!set.contains(cur)) {
                continue;
            }
            curMax = 0;
            helper(set, cur);
            max = Math.max(max, curMax);
        }
        
        return max;
    }
    
    private void helper(Set<Integer> set, int cur) {
        if (!set.contains(cur)) {
            return;
        }
        curMax++;
        set.remove(cur);
        helper(set, cur - 1);
        helper(set, cur + 1);
    }
}