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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        helper(root, "", res);
        return res;
    }
    
    private void helper(TreeNode node, String record, List<String> res) {
        if (node == null) {
            return;
        }
        
        if (node.left == null && node.right == null) {
            record += node.val;
            res.add(record);
            return;
        }
        
        record += node.val + "->";
        helper(node.left, record, res);
        helper(node.right, record, res);
    }
}