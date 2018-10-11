/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// time: n2
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        
        while(root.right != null) {
            root = root.right;
        }
        
        root.right = temp;
    }
}

// time: 1
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        
        helper(root);
    }
    
    private TreeNode helper(TreeNode node) {
        if (node == null) {
            return null;
        }
        
        TreeNode left = helper(node.left);
        TreeNode right = helper(node.right);
        
        if (left == null && right == null) {
            return node;
        }
        
        TreeNode temp = node.right;
        node.right = node.left;
        node.left = null;
        
        if (left != null) {
            left.right = temp;
        } else {
            node.right = temp;
        }
        
        if (right != null) {
            return right;
        }
        return left; 
    }
}