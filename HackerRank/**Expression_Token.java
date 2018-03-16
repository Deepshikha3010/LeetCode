/**
 * #Godaddy
 * An expression string will be a sequence of digits, operation characters, and space characters (' '). Convert this string into an array of strings for the tokens in the expression:
 * A sequence of digits becomes a single "token". You can also assume there are no spaces inside a number.
 * All other characters become their own "token", except the space character which you can ignore.
 * There are no negative numbers. "-" is a token.
 * <null> ==> { }
 * <empty string> ==> { }
 * 12345 ==> {"12345"}
 * abc ==> {"a","b","c"}
 * 12 + 2 * 3+4 ==> {"12","+","2","*","3","+","4"}
 * 1a2b3 ==> {“1","a","2","b","3"}
 * 
 * Pointer: 时间复杂度n, 空间复杂度n
 * 每sb.append()之前，先判定sb与c的字符是不是同时是数字。
 * 如果不是则将sb放入result，然后清空sb。
 * 
 * Solution 2:
 * 优化：一次性获取完整数字。靠近basic calculator模板。
 */

/**Solution 1 */
class Solution {
    public static List<String> expressionToken(String expr){
        List<String> result = new ArrayList<>();
        if(expr == null || expr.length() == 0){
            return result;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < expr.length(); i++){
            char c = expr.charAt(i);
            if(c == ' '){
                continue;
            }
            if(sb.length() != 0){
                if(!((c >= '0' && c <= '9') && (sb.charAt(sb.length() - 1) >= '0' && sb.charAt(sb.length() - 1) <= '9'))){
                    result.add(sb.toString());
                    sb = new StringBuilder();
                }
            }
            sb.append(c);
        }
        if(sb.length() != 0){
            result.add(sb.toString());
        }
        return result;
    }
}

/**Solution 2 */
class Solution {
    public List<String> expressionToken(String expr){
        List<String> result = new ArrayList<>();
        if(expr == null || expr.length() == 0){
            return result;
        }
        StringBuilder sb = new StringBuilder();
        //sb.append(Character.toString(expr.charAt(i)));
        for(int i = 0; i < expr.length(); i++){
            char c = expr.charAt(i);
            if(c == ' '){
                continue;
            }
            if(Character.isDigit(c)){
                int num = c - '0';
                while(i < expr.length() - 1 && Character.isDigit(expr.charAt(i + 1))){
                    num = num * 10 + Character.isDigit(expr.charAt(i + 1)) - '0';
                    i++;
                }
                sb.append(Integer.toString(num));
            }else{
                sb.append(Character.toString(c));
            }
            result.add(sb.toString());
        }
        return result;
    }
}
