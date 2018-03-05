/**
 * Solution 1（分治法）: 时间复杂度n，空间复杂度n
 * 
 * Solution 2 (遍历) : 时间复杂度n，空间复杂度n
 * 
 * Solution 3 (非递归) : 时间复杂度n，空间复杂度n
 * 注意：stack
 */

/**Solution 1 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        
        List<Integer> left = preorderTraversal(root.left);
        List<Integer> right = preorderTraversal(root.right);
        
        result.add(root.val);
        result.addAll(left);
        result.addAll(right);
        return result;
    }
}

/**Solution 2 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }
    
    private void helper(TreeNode root, List<Integer> result){
        if(root == null){
            return;
        }
        result.add(root.val);
        helper(root.left, result);
        helper(root.right, result);
    }
}

/**Solution 3 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            result.add(cur.val);
            if(cur.right != null){
                stack.push(cur.right);
            }
            if(cur.left != null){
                stack.push(cur.left);
            }
        }
        return result;
    }
}