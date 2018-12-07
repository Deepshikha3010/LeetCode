/**
 * Type: String
 * Time: n^3
 * Space: 1
 * 
 * 3 nested loop.
 */
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        // n^3
        int len = s.length();
        int max = 0;
        String res = "";
        for (int i = 0; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                String sub = s.substring(j, i);
                if (isPalindrome(sub)) {
                    if (max < sub.length()) {
                        res = sub;
                    }
                    max = Math.max(max, sub.length());
                }
            }
        }
        
        return res;
    }
    
    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

/**
 * 时间复杂度n2, 空间复杂度n2
 * 1. 创建一个二维数组，用来记录两个index的substring是不是palindrome。
 * 2. 讲单个字符设为true。
 * 3. 检查连续两个字符是不是相同，相同则更新result。
 * 4. 检查至少跨度为3的字符是不是palindrome。
 */

class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        int len = s.length();
        int max = 1;
        String result = Character.toString(s.charAt(0));
        boolean[][] f = new boolean[len][len];
        for(int i = 0; i < len; i++){
            f[i][i] = true;
        }
        for(int i = 0; i < len - 1; i++){
            f[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
            if(f[i][i + 1]){
                max = 2;
                result = s.substring(i, i + 2);
            }
        }
        for(int i = 0; i < len; i++){
            for(int j = 0; j < i - 1; j++){
                if(s.charAt(i) == s.charAt(j)){
                    f[j][i] = f[j + 1][i - 1];
                    if(f[j][i] && i - j + 1 > max){
                        max = i - j + 1;
                        result = s.substring(j, i + 1);
                    }
                }
            }
        }
        return result;
    }
}