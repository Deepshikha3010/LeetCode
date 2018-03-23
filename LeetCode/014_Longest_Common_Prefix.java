/**
 * Solution 1: 时间复杂度n2， 空间复杂度n
 * 1. 判定数组第一个字符串的片段有没有到头，到头的话直接返回当年StringBuilder。
 * 2. 没有到头则添加最新的字符片段。
 * 3. 用for循环判定是否与接下来的字符串片段符合。
 * 4. 满足条件len++。（此时的len可能会超出数组中字符串的最大长度）。
 * 
 * Solution 2: 时间复杂度n2， 空间复杂度n
 * 1. 选取数组第一个字符串，用indexOf倒序查找。
 * 2. 方法类似strStr()。
 */

/**Solution 1 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int len = 0;
        while(true){
            //get prefix
            if(len >= strs[0].length()){
                break;
            }
            sb.append(strs[0].charAt(len));
            //check match
            for(int i = 1; i < strs.length; i++){
                String str = strs[i];
                if(len >= str.length()){
                    return sb.toString().substring(0, len);
                }
                String sub = str.substring(0, len + 1);
                if(!sub.equals(sb.toString())){
                    return sb.toString().substring(0, len);
                }
            }
            len++;
        }
        return sb.toString();
    }
}

/**Solution 2 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        String pre = strs[0];
        for(int i = pre.length(); i >= 0; i--){
            String cur = pre.substring(0, i);
            int j = 0;
            for(; j < strs.length; j++){
                String next = strs[j];
                if(next.indexOf(cur) != 0){
                    break;
                }
            }
            if(j == strs.length){
                return cur;
            }
        }
        return "";
    }
}