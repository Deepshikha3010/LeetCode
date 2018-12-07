/**
 * Type: Two pointers 
 * Time: n
 * Space: 1
 * 
 * If leftMax is lower than rightmax, move left forward, since right now water in current position is already determined by the leftMax, vice versa.
 * */

class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int result = 0;
        int leftMost = 0, rightMost = 0;
        int left = 0, right = height.length - 1;
        while(left <= right) {
            leftMost = Math.max(leftMost, height[left]);
            rightMost = Math.max(rightMost, height[right]);
            if (leftMost < rightMost) {
                result += leftMost > height[left] ? (leftMost - height[left]) : 0;
                left++;
            } else {
                result += rightMost > height[right] ? (rightMost - height[right]) : 0;
                right--;
            }
        }
        return result;       
    }
}
