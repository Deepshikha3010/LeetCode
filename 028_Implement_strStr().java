/**
 * Solution 1: 时间复杂度n2，空间复杂度1
 * 注意：第一层循环需要小于haystack.length() - needle.length() + 1，因为减去needle长度后在首数位的前一位。
 */

/**Solution 1 */
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle == null || haystack == null || needle.length() > haystack.length()){
            return -1;
        }
        for(int i = 0; i < haystack.length() - needle.length() + 1; i++){
            int j;
            for(j = 0; j < needle.length(); j++){
                if(haystack.charAt(i + j) != needle.charAt(j)){
                    break;
                }
            }
            if(j == needle.length()){
                return i;
            }
        }
        return -1;
    }
}