/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null){
            return;
        }
        while(root.left != null){
            TreeLinkNode pre = root;
            while(root != null){
                root.left.next = root.right;
                root.right.next = (root.next != null) ? root.next.left : null;
                root = root.next;
            }
            root = pre.left;
        }
    }
}