# [301. Remove Invalid Parentheses](https://leetcode.com/problems/remove-invalid-parentheses/)

## Type

- Depth-first Search

## Explain

A navive solution is try to delete all of them, so time complexity is like permutation (2^n).

1. Count how many `(` and `)` should be deleted. The criteria is `left` >= `right`;
2. DFS starting from the index `0`. Delete `)` and then `(`.
3. When `r` == `l`, check if current string is valid. The criteria is scannning from left to right, `left` >= `right`.

<strong>Time Complexity:</strong>

When scanning from left to right, each `(` and `)` has chance (0/1) to go to next level. -- n*2^(l+r)

<strong>Space Complexity:</strong>

For each level we have to keep a copy of current string. -- n^2*(l+r)

## Code

### Solution 1 - DFS

```java
/**
 * Type: DFS
 * Time: 2^n
 * Space: n^2*(l+r)
 */
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        
        int l = 0, r = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                l++;
            } else if (c == ')') {
                if (l > 0) {
                    l--;
                } else {
                    r++;
                }
            }
        }
        
        dfs(s, 0, l, r, res);
        return res;
    }
    
    private void dfs(String s, int index, int l, int r, List<String> res) {
        if (l == 0 && r == 0) {
            if (isValid(s)) res.add(s);
            return;
        }
        
        for (int i = index; i < s.length(); i++) {
            if (i != index && s.charAt(i - 1) == s.charAt(i)) continue;
            
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                String next = s.substring(0, i) + s.substring(i + 1);
                if (r > 0) {
                    dfs(next, i, l, r - 1, res);
                } else if (l > 0) {
                    dfs(next, i, l - 1, r, res);
                }
            }
        }
    }
    
    private boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') count++;
            if (c == ')') count--;
            if (count < 0) return false;
        }
        return count == 0;
    }
}
```