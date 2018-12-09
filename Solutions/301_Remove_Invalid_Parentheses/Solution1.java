/**
 * Type: DFS
 * Time: n*2^(l+r)
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