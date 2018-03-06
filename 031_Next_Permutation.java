/**
 * Two Pass
 * 注意：curPos的数右边的数应该是从右到左升序，所以不用sort，直接反转即可。
 * 
 * Solution 1(Two Pass): 时间复杂度n，空间复杂度1
 * 1. 从右向左遍历找到第一个比右边数小的数的位置curPos。
 * 2. 再从右向左遍历，找到第一个比curPos位置数大的数的位置。
 * 3. 交换找到的两个数。
 * 4. 如果当初curPos一直没找到，则全数组翻转。如果找到了则从curPos右边一位开始到最后一位翻转。
 */

/**Solution 1 */
class Solution {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }
        int len = nums.length;
        int curPos = len - 1;
        for(int i = len - 2; i >= 0; i--){
            if(nums[i] < nums[i + 1]){
                curPos = i;
                break;
            }
        }
        for(int i = len - 1; i >= 0 && i > curPos; i--){
            if(nums[i] > nums[curPos]){
                swap(i, curPos, nums);
                break;
            }
        }
        int startPos;
        int endPos = len - 1;
        if(curPos == len - 1){
            startPos = 0;
        }else{
            startPos = curPos + 1;
        }
        while(startPos < endPos){
            swap(startPos, endPos, nums);
            startPos++;
            endPos--;
        }
    }
    
    private void swap(int start, int end, int[] nums){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}