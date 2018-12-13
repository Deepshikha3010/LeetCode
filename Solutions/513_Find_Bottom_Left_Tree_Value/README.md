# [513. Find Bottom Left Tree Value](https://leetcode.com/problems/find-bottom-left-tree-value/)

## Type

- Tree
- Breadth-first Search

## Explain

Tree level based BFS, and record the first value of each level.

## Code

### Solution 1 - Tree BFS

```java
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
```