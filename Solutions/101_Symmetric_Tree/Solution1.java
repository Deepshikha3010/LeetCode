/**
 * Type: Tree Recursion
 * Time: n
 * Space: n (worst case: linear tree)
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        return isValid(root.left, root.right);
    }
    
    private boolean isValid(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        
        return isValid(left.left, right.right) && isValid(left.right, right.left);
    }
}