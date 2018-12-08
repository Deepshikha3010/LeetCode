/**
 * LeetCode: https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * Type: DFS
 * Time: n
 * Space: n
 */
class Solution {
  private class Entry {
      TreeNode node;
      int level;
      
      Entry(TreeNode node, int level) {
          this.node = node;
          this.level = level;
      }
  }
  
  public int minDepth(TreeNode root) {
      if (root == null) {
          return 0;
      }
      
      Stack<Entry> stack = new Stack<>();
      stack.push(new Entry(root, 1));
      
      int min = Integer.MAX_VALUE;
      while (!stack.isEmpty()) {
          Entry cur = stack.pop();
          if (cur.node.left == null && cur.node.right == null) {
              min = Math.min(min, cur.level);
          }
          if (cur.node.left != null) {
              stack.push(new Entry(cur.node.left, cur.level + 1));
          }
          if (cur.node.right != null) {
              stack.push(new Entry(cur.node.right, cur.level + 1));
          }
      }
      
      return min;
  }
}