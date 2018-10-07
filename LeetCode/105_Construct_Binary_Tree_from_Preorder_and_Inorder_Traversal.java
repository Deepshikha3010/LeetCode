/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
In inorder array, a node's left nodes in the array are on its left;

In preordere array, a node's left node in the array is its next item,
and its right node in the array is the left node index + left nodes length in inorder array.

 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0){
            return null;
        }
        return helper(preorder, inorder, 0, 0, inorder.length - 1);
    }
    
    private TreeNode helper(int[] preorder, int[] inorder, int pre_st, int in_st, int in_end) {
        if (pre_st >= preorder.length || in_st > in_end) {
            return null;
        }
        TreeNode cur = new TreeNode(preorder[pre_st]);
        int i = in_st;
        while(true) {
            if (inorder[i] == cur.val) {
                break;
            }
            i++;
        }
        cur.left = helper(preorder, inorder, pre_st + 1, in_st, i - 1);
        cur.right = helper(preorder, inorder, pre_st + (i - in_st + 1), i + 1, in_end);
        return cur;
    }
}