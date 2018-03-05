/**
 * Solution 1（分治法）: 时间复杂度n，空间复杂度n
 * 
 * Solution 2 (遍历) : 时间复杂度n，空间复杂度n
 * 
 * Solution 3 (非递归--压栈) : 时间复杂度n，空间复杂度n
 */

 /**Solution 1 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        List<Integer> left = inorderTraversal(root.left);
        List<Integer> right = inorderTraversal(root.right);
        result.addAll(left);
        result.add(root.val);
        result.addAll(right);
        return result;
    }
}

/**Solution 2 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }
    
    private void helper(TreeNode root, List<Integer> result){
        if(root == null){
            return;
        }
        helper(root.left, result);
        result.add(root.val);
        helper(root.right, result);
    }
}

/**Solution 3 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            result.add(node.val);
            cur = node.right;
        }
        return result;
    }
}