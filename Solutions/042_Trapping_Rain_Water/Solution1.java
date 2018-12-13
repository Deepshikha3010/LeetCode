/**
 * Type: Two Pointers
 * Time: n
 * Space: 1
 */
class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int sum = 0;
        
        while (left < right) {
            int leftCur = height[left];
            int rightCur = height[right];
            leftMax = Math.max(leftMax, leftCur);
            rightMax = Math.max(rightMax, rightCur);
            
            if (leftMax < rightMax) {
                sum += leftMax - leftCur;
                left++;
            } else {
                sum += rightMax - rightCur;
                right--;
            }
        }
        
        return sum;
    }
}