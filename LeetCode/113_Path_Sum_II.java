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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        helper(root, sum, new ArrayList<>(), res);
        return res;
    }
    
    private void helper(TreeNode node, int sum, List<Integer> record, List<List<Integer>> res) {
        if (node == null) {
            return;
        }
        
        if (node.left == null && node.right == null && sum == node.val) {
            record.add(node.val);
            res.add(new ArrayList<>(record));
            record.remove(record.size() - 1);
            return;
        }
        
        record.add(node.val);
        helper(node.left, sum - node.val, record, res);
        helper(node.right, sum - node.val, record, res);
        record.remove(record.size() - 1);
    }
}