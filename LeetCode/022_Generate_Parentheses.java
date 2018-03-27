/**
 * 时间复杂度2n, 空间复杂度n
 * 1. 用pre和post分别代表()剩余数。
 * 2. 只有post > pre的时候才能继续添加)。
 */

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if(n <= 0){
            return result;
        }
        helper(n * 2, n, n, new StringBuilder(), result);
        return result;
    }
    
    private void helper(int n, int pre, int post, StringBuilder sb, List<String> result){
        if(n <= 0){
            result.add(sb.toString());
        }else{
            if(pre > 0){
                sb.append('(');
                helper(n - 1, pre - 1, post, sb, result);
                sb.deleteCharAt(sb.length() - 1);
            }
            if(post > 0 && post > pre){
                sb.append(')');
                helper(n - 1, pre, post - 1, sb, result);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}