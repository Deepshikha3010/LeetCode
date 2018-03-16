/**
 * 插入位置优先考虑最左边，所以先考虑start位置。
 * 二分法结果要么start和end踩中，要么没踩中（target本应出现夹缝位置）。
 * 如果踩中，返回踩中位置即可。
 * 如果没踩中，返回比target大的最近一个位置。
 * 
 * Solution:
 * 1. 二分法：mid与target相等时因为优先考虑最左边，end = mid。
 * 2. 判定所在位置是否大于等于target。
 */

class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int start = 0, end = nums.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                end = mid;
            }else if(nums[mid] < target){
                start = mid;
            }else{
                end = mid;
            }
        }
        if(nums[start] >= target){
            return start;
        }else if(nums[end] >= target){
            return end;
        }else{
            return end + 1;
        }
    }
}