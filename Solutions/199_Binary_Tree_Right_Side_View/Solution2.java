/**
 * Type: DFS
 * Time: n
 * Space: n
 */
class Solution {
    int max = 0;
    
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        helper(root, res, 0);
        
        return res;
    }
    
    private void helper(TreeNode node, List<Integer> res, int count) {
        if (node == null) {
            return;
        }
        
        count++;
        if (count > max) {
            res.add(node.val);
            max = count;
        }
        
        helper(node.right, res, count);
        helper(node.left, res, count);
    }
}