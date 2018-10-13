class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        int pre = nums[0];
        int len = 0;
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            if (pre + len + 1 == cur) {
                len++;
            } else {
                if (len == 0) {
                    res.add(Integer.toString(pre));
                } else {
                    res.add(pre + "->" + (pre + len));
                }
                pre = cur;
                len = 0;
            }
        }
        
        if (len == 0) {
            res.add(Integer.toString(pre));
        } else {
            res.add(pre + "->" + (pre + len));
        }

        return res;
    }
}