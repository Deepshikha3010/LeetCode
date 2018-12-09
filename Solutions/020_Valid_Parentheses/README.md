# [20. Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)

## Type

- Stack

## Explain

Use `stack` to track previous corresponding items. Solution 2 is a clever way to reduce code.

## Code

### Solution 1 - Stack (Normal)

```java
/**
 * Type: Stack
 * Time: n
 * Space: n
 */
class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.empty()) {
                    return false;
                }
                if (c == ')' && stack.pop() != '(') {
                    return false;
                } else if (c == '}' && stack.pop() != '{') {
                    return false;
                } else if (c == ']' && stack.pop() != '[') {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
```

### Solution 2 - Stack (Clever)

```java
/**
 * Type: Stack
 * Time: n
 * Space: n
 */
class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else {
                if (stack.isEmpty() || stack.pop() != c) return false;
            }
        }
        
        return stack.isEmpty();
    }
}
```