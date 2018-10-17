class Solution {
    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0) {
            return T;
        }
        
        int[] res = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            int cur = T[i];
            while (!stack.isEmpty() && T[stack.peek()] < cur) {
                int preIndex = stack.pop();
                res[preIndex] = i - preIndex;
            }
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            int preIndex = stack.pop();
            res[preIndex] = 0;
        }
        
        return res;
    }
}