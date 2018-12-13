# [102. Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/)

## Type

- Tree

## Explain

- Normal BFS level traveral.
- Since when we do DFS, left nodes on the same level always being put into list ealier than right nodes, so it still keep the order.

## Solution 1 - Iteration (BFS)

```java
/**
 * Type: Tree
 * Time: n
 * Space: n
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            res.add(list);
        }
        
        return res;
    }
}
```

### Solution 2 - Recursion (DFS)

```java
/**
 * Type: Tree
 * Time: n
 * Space: n
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        
        dfs(root, 0, res);
        
        return res;
    }
    
    private void dfs(TreeNode node, int level, List<List<Integer>> res) {
        if (node == null) return;
        
        if (res.size() <= level) res.add(new ArrayList<>());
        
        res.get(level).add(node.val);
        dfs(node.left, level + 1, res);
        dfs(node.right, level + 1, res);
    } 
}
```