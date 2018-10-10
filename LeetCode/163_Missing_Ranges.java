class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        
        int missing = lower;
        
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int cur = nums[i];
            if (missing < cur) {
                res.add(getRange(missing, cur - 1));
                missing = cur + 1;
            } else {
                missing++;
            }
            if (cur == Integer.MAX_VALUE) {
                return res;
            }
        }
        
        if (missing <= upper) {
            res.add(getRange(missing, upper));
        }
        
        return res;
    }
    
    private String getRange(int start, int end) {
        if (start < end) {
            return Integer.toString(start) + "->" + Integer.toString(end);
        }
        return Integer.toString(start);
    }
}