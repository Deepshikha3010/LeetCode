/**
 * Solution 1:
 * 时间复杂度n，空间复杂度n
 * 类似Basic Caculator做法，两个StringBuilder，一个记录result,一个记录word。
 * 
 * Solution 2:
 * 时间复杂度n，空间复杂度n
 * 直接用split
 */

/**Solution 1 */
public class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        char[] cs = s.trim().toCharArray();
        StringBuilder sb = new StringBuilder();
        StringBuilder cur = new StringBuilder();
        for(int i = cs.length - 1; i >= 0; i--){
            char c = cs[i];
            if(c == ' '){
                sb.append(c);
                while(i > 0 && cs[i - 1] == ' '){
                    i--;
                }
            }else{
                cur.append(c);
                while(i > 0 && cs[i - 1] != ' '){
                    cur.append(cs[i - 1]);
                    i--;
                }
                sb.append(cur.reverse().toString());
                cur = new StringBuilder();
            }
        }
        return sb.toString();
    }
}

/**Solution 2 */
public class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        String[] array = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i = array.length - 1; i >= 0; i--){
            String str = array[i];
            System.out.println(str);
            sb.append(str + " ");
        }
        return sb.toString().trim();
    }
}