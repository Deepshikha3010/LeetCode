class Solution {
    int min = Integer.MAX_VALUE;
    int result = 0;
    
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            helper(nums, i, target, nums[i]);
        }
        return result;
    }
    
    private void helper(int[] nums, int index, int target, int first) {
        int head = index + 1, tail = nums.length - 1;
        while(head < tail) {
            int sum = nums[head] + nums[tail] + first;
            int distance = Math.abs(target - sum);
            if (sum <= target) {
                head++;
            } else if (sum > target) {
                tail--;
            }
            if (min > distance) {
                result = sum;
                min = distance;
            }
        }
    }
}