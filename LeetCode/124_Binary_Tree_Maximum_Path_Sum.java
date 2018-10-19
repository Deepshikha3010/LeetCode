/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    class Result {
        int max;
        int cur;
        
        Result(int max, int cur) {
            this.max = max;
            this.cur = cur;
        }
    }
    
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return helper(root).max;
    }
    
    private Result helper(TreeNode node) {
        if (node == null) {
            return new Result(Integer.MIN_VALUE, Integer.MIN_VALUE);
        }
        
        Result left = helper(node.left);
        Result right = helper(node.right);
        
        int value = node.val;
        int curMax, max, curInMax;
        
        if (left.cur < 0 && right.cur < 0) {
            curMax = value;
            curInMax = Integer.MIN_VALUE;
        } else if (left.cur < 0) {
            curMax = Math.max(value, right.cur + value);
            curInMax = Integer.MIN_VALUE;
        } else if (right.cur < 0) {
            curMax = Math.max(value, left.cur + value);
            curInMax = Integer.MIN_VALUE;
        } else {
            curMax = Math.max(value, Math.max(value + left.cur, value + right.cur));
            curInMax = value + left.cur + right.cur;
        }
        
        max = Math.max(curInMax, curMax);
        max = Math.max(max , Math.max(left.max, right.max));
        
        return new Result(max, curMax);
    }
}