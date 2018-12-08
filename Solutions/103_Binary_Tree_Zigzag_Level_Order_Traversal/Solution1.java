/**
 * LeetCode: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * Time: n
 * Space: n
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int count = 0;
        
        while (!stack.isEmpty()) {
            int size = stack.size();
            Stack<TreeNode> temp = new Stack<>();
            List<Integer> record = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = stack.pop();
                record.add(cur.val);
                if (count % 2 == 0) {
                    if (cur.left != null) {
                        temp.push(cur.left);
                    }
                    if (cur.right != null) {
                        temp.push(cur.right);
                    }
                } else {
                    if (cur.right != null) {
                        temp.push(cur.right);
                    }
                    if (cur.left != null) {
                        temp.push(cur.left);
                    }
                }
            }
            stack = temp;
            count++;
            res.add(record);
        }
        
        return res;
    }
}