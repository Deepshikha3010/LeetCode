/**
 * LeetCode: https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 * Time: n
 * Space: n
 */
class Solution {
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
      List<List<Integer>> res = new ArrayList<>();
      if (root == null) {
          return res;
      }
      
      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);
      
      List<Integer> record;
      
      while (!queue.isEmpty()) {
          int size = queue.size();
          record = new ArrayList<>();
          for (int i = 0; i < size; i++) {
              TreeNode cur = queue.poll();
              record.add(cur.val);
              if (cur.left != null) {
                  queue.offer(cur.left);
              }
              if (cur.right != null) {
                  queue.offer(cur.right);
              }
          }
          res.add(record);
      }
      
      Collections.reverse(res);
      return res;
  }
}