/**
 * LeetCode: https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * Type: BFS
 * Time: n (worst)
 * Space: n
 */
class Solution {
  public int minDepth(TreeNode root) {
      if (root == null) {
          return 0;
      }
      
      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);
      int count = 1;
      
      while (!queue.isEmpty()) {
          int size = queue.size();
          for (int i = 0; i < size; i++) {
              TreeNode cur = queue.poll();
              if (cur.left == null && cur.right == null) {
                  return count;
              }
              if (cur.left != null) {
                  queue.offer(cur.left);
              }
              if (cur.right != null) {
                  queue.offer(cur.right);
              }
          }
          count++;
      }
      
      return count;
  }
}