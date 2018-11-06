// Template for Basic Calculator I/II/III
class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        Stack<String> stack = new Stack<>();
        int res = 0;
        char op = '+';
        s = s.trim();
        
        Set<String> set = new HashSet<>(Arrays.asList(new String[]{"+", "-", "/", "*"}));
        
        int index = 0;
        while (index < s.length()) {
            while (index < s.length() && s.charAt(index) == ' ') {
                index++;
            }
            if (index >= s.length()) {
                break;
            }
            
            if (Character.isDigit(s.charAt(index))) {
                int cur = (int)(s.charAt(index) - '0');
                while (index + 1 < s.length() && Character.isDigit(s.charAt(index + 1))) {
                    index++;
                    cur = cur * 10 + (int)(s.charAt(index) - '0');
                }
                pushNumToStack(stack, op, cur);
            } else if (s.charAt(index) == '(') {
                stack.push(Character.toString(op));
                op = '+';
            } else if (s.charAt(index) == ')') {
                int cur = 0;
                while (!set.contains(stack.peek())) {
                    cur += Integer.parseInt(stack.pop());
                }
                pushNumToStack(stack, stack.pop().charAt(0), cur);
            } else {
                op = s.charAt(index);
            }
            
            
            index++;
        }
        
        while (!stack.isEmpty()) {
            String str = stack.pop();
            if (!set.contains(str)) {
                res += Integer.parseInt(str);
            }
        }
        
        return res;
    }
    
    private void pushNumToStack(Stack<String> stack, char op, int cur) {
        if (op == '+') {
            stack.push(Integer.toString(cur));
        } else if (op == '-') {
            stack.push(Integer.toString(-cur));
        } else if (op == '*') {
            String s = Integer.toString(Integer.parseInt(stack.pop()) * cur);
            stack.push(s);
        } else {
            String s = Integer.toString(Integer.parseInt(stack.pop()) / cur);
            stack.push(s);
        }
    }
}

// 1 stack
class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<>();
        int number = 0;
        int sign = 1;
        int result = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number = 10 * number + (int)(c - '0');
            } else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result += sign * number;
                number = 0;
                result *= stack.pop();
                result += stack.pop();
            }
        }
        
        if (number != 0) {
            result += sign * number;
        }
        
        return result;
    }
}

// 2 stacks
class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        Stack<String> stack = new Stack<>();
        Stack<Character> signs = new Stack<>();
        Set<Character> set = new HashSet<>(Arrays.asList(new Character[]{'-', '+'}));
        
        s = s.trim();
        
        int sum = 0;
        signs.add('+');
        
        int i = 0;        

        while (i < s.length()) {
            char c = s.charAt(i);
            
            if ('0' <= c && c <= '9') {
                StringBuilder sb = new StringBuilder();
                sb.append(c);
                while (i + 1 < s.length() && '0' <= s.charAt(i + 1) && s.charAt(i + 1) <= '9') {
                    sb.append(s.charAt(i + 1));
                    i++;
                }
                stack.push(sb.toString());
            }
            
            if (c == ')') {
                int temp = 0;
                while (!stack.peek().equals("(")) {
                    String cur = stack.pop();
                    int num = Integer.parseInt(cur);
                    char sign = signs.pop();
                    if (sign == '+') {
                        temp += num;
                    } else {
                        temp -= num;
                    }
                }
                stack.pop();
                stack.add(Integer.toString(temp));
            } else if (c == '(') {
                stack.push(Character.toString('('));
                signs.push('+');
            } else if (set.contains(c)) {
                signs.push(c);
            }
            i++;
        }
        
        while (!stack.isEmpty()) {
            int num = Integer.parseInt(stack.pop());
            if (signs.pop() == '+') {
                sum += num;
            } else {
                sum -= num;
            }
        }
        
        return sum;
    }
}
