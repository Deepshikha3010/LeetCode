/**
 * HashMap + Two Pointers
 * 时间复杂度n, 空间复杂度1
 * 1. 快指针更新record，当没有重复时，更新max。
 * 2. 有重复时进入slow的while循环，更新record。
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int[] record = new int[256];
        int fast = 0, slow = 0;
        int len = s.length();
        int max = 0;
        while(fast < len){
            char head = s.charAt(fast);
            record[head]++;
            fast++;
            if(record[head] <= 1){
                max = Math.max(fast - slow, max);
            }
            while(slow < fast && record[head] > 1){
                char tail = s.charAt(slow);
                slow++;
                record[tail]--;
            }
        }
        return max;
    }
}