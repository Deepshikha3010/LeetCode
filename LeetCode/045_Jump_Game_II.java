class Solution {
  public int jump(int[] nums) {
      if (nums == null || nums.length <= 1) {
          return 0;
      }
      
      int range = nums[0], maxRange = range;
      int count = 0;
      
      for (int i = 0; i < nums.length; i++) {
          int cur = nums[i];
          maxRange = Math.max(maxRange, i + cur);
          if (i == nums.length - 1 || i >= range) {
              count++;
              if (range >= nums.length) {
                  break;
              }
              range = maxRange;
          }
      }
      
      return count;
  }
}