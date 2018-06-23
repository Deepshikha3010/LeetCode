/**
 * 窗口双指针模板：两个指针都只遍历一次数组，没有回头，因此时间复杂度为n。
 * 快指针负责判定，慢指针负责固定起点。
 * 
 * Solution：时间复杂度n，空间复杂度1
 * 1. 设定条件sum = 0。result为不可能的极限值Integer.MAX_VALUE.
 * 2. 第一层循环为慢指针slow。
 * 3. 第二层循环为快指针fast。必须同时满足fast < nums.length和sum < s两个条件。
 * 4. 如果sum 满足条件则判定与调整result的值。
 * 5. 因为slow在下次循环时要前进一位，外层循环最后一步sum -= nums[slow].
 * 6. 最后判定是否找到了符合要求的子数组。
 */

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int fast = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for(int slow = 0; slow < nums.length; slow++){
            while(fast < nums.length && sum < s){
                sum += nums[fast];
                fast++;
            }
            if(sum >= s){
                result = Math.min(result, fast - slow);
            }
            sum -= nums[slow];
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
