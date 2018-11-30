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
  int max;
  
  public int maxDepth(TreeNode root) {
      if (root == null) {
          return 0;
      }
      
      max = 0;
      helper(root, 0);
      return max;
  }
  
  private void helper(TreeNode node, int depth) {
      if (node == null) {
          return;
      }
      
      max = Math.max(++depth, max);
      helper(node.left, depth);
      helper(node.right, depth);
  }
}