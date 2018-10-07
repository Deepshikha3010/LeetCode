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
    private class Check {
        boolean valid;
        int max;
        int min;
        Check(boolean valid, int max, int min) {
            this.valid = valid;
            this.max = max;
            this.min = min;
        }
    }
    
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root).valid;
    }
    
    private Check helper(TreeNode node) {
        if (node == null) {
            return new Check(true, Integer.MIN_VALUE, Integer.MAX_VALUE);           
        }
        Check left = helper(node.left);
        Check right = helper(node.right);
        int value = node.val;
        if (!left.valid || !right.valid) {
            return new Check(false, 0, 0);
        }
        if (node.left != null && left.max >= node.val || node.right != null && right.min <= node.val) {
            return new Check(false, 0, 0);
        }
        int min = Math.min(value, left.min);
        int max = Math.max(value, right.max);
        return new Check(true, max, min);
    }   
}
