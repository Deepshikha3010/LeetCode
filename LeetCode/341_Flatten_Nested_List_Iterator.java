/**
 * Type: Stack
 * Time: worst n, average is 1
 * Space: n
 * 
 * If current top item is a list, flatten it by using pushListToStack.
 */

public class NestedIterator implements Iterator<Integer> {

    Stack<NestedInteger> stack;
    
    private void pushListToStack(List<NestedInteger> list) {
        Stack<NestedInteger> temp = new Stack<>();
        for (int i = 0; i < list.size(); i++) {
            temp.push(list.get(i));
        }
        
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }
    
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        pushListToStack(nestedList);
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            return stack.pop().getInteger();
        }
        
        return null;
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            pushListToStack(stack.pop().getList());
        }
        
        return !stack.isEmpty();
    }
}

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */