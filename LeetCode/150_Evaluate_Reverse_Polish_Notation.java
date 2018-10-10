class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        
        int res = 0;
        Stack<String> stack = new Stack<>();
        Set<String> ops = new HashSet<>(Arrays.asList(new String[]{"+", "-", "*", "/"}));
        
        for (int i = 0; i < tokens.length; i++) {
            String cur = tokens[i];
            if (!ops.contains(cur)) {
                stack.push(cur);
            } else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                if (cur.equals("*")) {
                    stack.push(Integer.toString((num1 * num2)));
                } else if (cur.equals("/")) {
                    stack.push(Integer.toString((num1 / num2)));
                } else if (cur.equals("+")) {
                    stack.push(Integer.toString((num1 + num2)));
                } else {
                    stack.push(Integer.toString((num1 - num2)));
                }
            }
        }
        
        while(!stack.isEmpty()) {
            res += Integer.parseInt(stack.pop());
        }
        
        return res;
    }
}