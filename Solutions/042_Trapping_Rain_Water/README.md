# [42. Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/)

## Type

- Two Pointers

## Explain

1. 2 pointers `left` and `right` starting from each end of the array. Use `leftMax` and `rightMax` record the max height on each side.
2. The pointer has the lower side will add such as `leftMax - height[left]` to `sum`, and then move forward.

## Code

### Solution 1 - Two Pointers

```java
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
```