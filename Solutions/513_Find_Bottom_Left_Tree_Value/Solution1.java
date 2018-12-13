/**
 * Type: Tree BFS
 * Time: n
 * Space: logn (height, worst can be n)
 */
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) return -1;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = -1;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (i == 0) res = cur.val;
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
        }
        
        return res;
    }
}