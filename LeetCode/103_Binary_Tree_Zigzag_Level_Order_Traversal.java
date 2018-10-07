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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        Stack<TreeNode> curLevel = new Stack<>();
        Stack<TreeNode> nextLevel = new Stack<>();
        Stack<TreeNode> temp = new Stack<>();
        
        curLevel.push(root);
        boolean normalOrder = true;
        
        while(!curLevel.isEmpty()) {
            List<Integer> record = new ArrayList<>();
            while(!curLevel.isEmpty()) {
                TreeNode cur = curLevel.pop();
                record.add(cur.val);
                if (normalOrder) {
                    if (cur.left != null) {
                        nextLevel.push(cur.left);
                    }
                    if (cur.right != null) {
                        nextLevel.push(cur.right);
                    }
                } else {
                    if (cur.right != null) {
                        nextLevel.push(cur.right);
                    }
                    if (cur.left != null) {
                        nextLevel.push(cur.left);
                    }
                }
            }
            temp = curLevel;
            curLevel = nextLevel;
            nextLevel = temp;
            result.add(record);
            normalOrder = !normalOrder;
        }
        
        return result;
    }
}