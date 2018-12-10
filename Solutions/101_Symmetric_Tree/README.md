# [101. Symmetric Tree](https://leetcode.com/problems/symmetric-tree/)

## Type

- Tree

## Explain

`Tree recursion` is more intuitve. Except the root, each recursion will compare 2 nodes.

## Code

### Solution 1 - Tree Recursion

```java
/**
 * Type: Tree Recursion
 * Time: n
 * Space: n (worst case: linear tree)
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        return isValid(root.left, root.right);
    }
    
    private boolean isValid(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        
        return isValid(left.left, right.right) && isValid(left.right, right.left);
    }
}
```

### Solution 1 - Tree Iteration

```java
/**
 * Type: Tree Iteration
 * Time: n
 * Space: n
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        
        return true;
    }
}
```