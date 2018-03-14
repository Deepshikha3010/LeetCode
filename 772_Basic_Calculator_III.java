/**
 * 时间复杂度n, 空间复杂度n
 * 1. 创建两个stack，一个放数字，一个放符号。
 * 2. 遇到数字将完整数字放入nums顶端。
 * 3. 遇到(将其放入ops顶端。
 * 4. 遇到)将括号里面所有数字消除。（因为步骤5将能消除的消除了，不存在5 * 2 + 1的情况。也不会出现括号内没有运算符的情况）
 * 5. 遇到运算符号，将所有能消除的消除。（压栈，消除前面所有*和/的运算）
 * 6. 因为前面是压栈运算，最后的nums可以直接从右向左运算。（与步骤4同理）
 * 注意：
 * 1. 所有消除都是从右向左。
 * 2. nums最后留下来的都是没有括号的情况，
 */

class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        int num = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == ' '){
                continue;
            }
            if(Character.isDigit(c)){
                num = c - '0';
                while(i < s.length() - 1 && Character.isDigit(s.charAt(i + 1))){
                    num = num * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }
                nums.push(num);
                num = 0;
            }else if (c == '(') {
                ops.push(c);
            } else if (c == ')') {
                // do the math when we encounter a ')' until '('
                while (ops.peek() != '('){
                    nums.push(operation(ops.pop(), nums.pop(), nums.pop()));
                } 
                ops.pop(); // get rid of '(' in the ops stack
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!ops.isEmpty() && precedence(c, ops.peek())){
                    nums.push(operation(ops.pop(), nums.pop(),nums.pop()));
                } 
                ops.push(c);
            }
        }
        while(!ops.isEmpty()){
            nums.push(operation(ops.pop(), nums.pop(), nums.pop()));
        }
        return nums.pop();
    }
    
    private boolean precedence(char future, char cur){
        if(cur == '(' || cur == ')'){
            return false;
        }
        if((cur == '+' || cur == '-') && (future == '*' || future == '/')){
            return false;
        }
        return true;
    }
    
    private int operation(char opr, int num2, int num1){
        if(opr == '*'){
            return num1 * num2;
        }else if(opr == '/'){
            return num1 / num2;
        }else if(opr == '+'){
            return num1 + num2;
        }else{
            return num1 - num2;
        }
    }
}