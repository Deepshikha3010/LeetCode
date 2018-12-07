/**
 * Type: Two pointers
 * Time: n
 * Space: 1
 * 
 * The only reason we want two pointers get closer is that there might be higher lines in between.
 */

class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        
        int head = 0, tail = height.length - 1;
        int max = 0;
        while(head < tail) {
            int h = Math.min(height[head], height[tail]);
            max = Math.max(h * (tail - head), max);
            if (height[head] < height[tail]) {
                head++;
            } else {
                tail--;
            }
        }
        
        return max;
    }
}