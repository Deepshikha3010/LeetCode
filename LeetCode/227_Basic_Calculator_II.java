/**
 * Solution 1 (Stack): 时间复杂度n, 空间复杂度n
 * 1. 用expressionToken()将string分为tokens（防止42被拆分成4 2）。
 * 2. 用Stack和一个boolean flag将* /的情况先处理掉，剩下的token放进Stack。
 * 3. 将Stack转化成List，按照顺序做加减法。
 * 注意：
 * 1. int to char: Character.forDigit(num, 10)。
 * 2. char to int: num - '0'。
 * 3. String to int: Integer.parseInt(strNum)。
 * 4. int to String: Integer.toString(num)。
 * 
 * Solution 2 (Stack): 时间复杂度n, 空间复杂度n
 * 优化：
 * 1. 用一个int num记录当前还未放入stack的数字，用来处理例如42这种情况。
 * 2. 用一个char opr记录stack最上层数字与当前num之间的运算关系。
 * 3. Stack中存储的只有数字，数字的加减关系通过正负号表示。乘除全在Stack解决。
 * 
 * Solution 3 (Stack): 时间复杂度n, 空间复杂度n
 * 优化(变化):
 * 1. 遇到数字用while循环获得完整数字。
 * 注意：
 * 1. 其实也是压栈（向右压栈），消除右边所有*和/符号运算。
 * 2. 不能向左压栈，因为要保留最近一个数字，为了后面可能的*和/符号运算。
 */

/**Solution 1 */
class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        Stack<String> stack = new Stack<>();
        List<String> tokens = expressionToken(s);
        int len = tokens.size();
        boolean flag = false;
        for(int i = 0; i < len; i++){
            String c = tokens.get(i);
            if(flag){
                String opr = stack.pop();
                int firstNum = Integer.parseInt(stack.pop());
                int lastNum = Integer.parseInt(c);
                stack.push(Integer.toString(cal(firstNum, lastNum, opr)));
                flag = false;
            }else{
                if(c.equals("*") || c.equals("/")){
                    flag = true;
                }
                stack.push(c);
            }
        }
        List<String> expr = new ArrayList<>(stack);
        int result = Integer.parseInt(expr.get(0));
        for(int i = 1; i < expr.size(); i += 2){    
            result = cal(result, Integer.parseInt(expr.get(i + 1)), expr.get(i));
        }
        return result;
    }
    
    private int cal(int num1, int num2, String opr){
        if(opr.equals("*")){
            return num1 * num2;
        }else if(opr.equals("/")){
            return num1 / num2;
        }else if(opr.equals("+")){
            return num1 + num2;
        }else{
            return num1 - num2;
        }
    }
    
    public List<String> expressionToken(String expr){
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
    public int calculate(String s) {
        if(s == null){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char opr = '+';
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + (c - '0');
            }
            if((c != ' ' && !Character.isDigit(c)) || i + 1 == s.length()){
                if(opr == '+'){
                    stack.push(num);
                }else if(opr == '-'){
                    stack.push(-num);
                }else if(opr == '*'){
                    stack.push(stack.pop() * num);
                }else{
                    stack.push(stack.pop() / num);
                }
                opr = c;
                num = 0;
            }
        }
        int result = 0;
        while(!stack.isEmpty()){
            int n = stack.pop();
            result += n;
        }
        return result;
    }
}

/**Solution 3 */
class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        char opr = '+';
        int num = 0;
        s = s.trim();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == ' '){
                continue;
            }
            if(Character.isDigit(c)){
                num = c - '0';
                while(i < s.length() - 1 && Character.isDigit(s.charAt(i + 1))){
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
            }
            if(!Character.isDigit(c) || i == s.length() - 1){
                if(opr == '+'){
                    stack.push(num);
                }else if(opr == '-'){
                    stack.push(-num);
                }else if(opr == '*'){
                    stack.push(stack.pop() * num);
                }else{
                    stack.push(stack.pop() / num);
                }
                opr = c;
            }
        }
        int result = 0;
        while(!stack.isEmpty()){
            result += stack.pop();
        }
        return result;
    }
}