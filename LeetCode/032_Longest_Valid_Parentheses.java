class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int len = s.length();
        int max = 0;
        int leftMost = -1;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    leftMost = i;
                } else {
                    int pre = stack.pop();
                    if (stack.isEmpty()) {
                        max = Math.max(max, i - leftMost);
                    } else {
                        max = Math.max(max, i - stack.peek());
                    }
                }
            }
        }
        
        return max;
    }
}

