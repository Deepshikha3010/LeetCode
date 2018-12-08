# [199. Binary Tree Right Side View](https://leetcode.com/problems/binary-tree-right-side-view/)

## Type

- Breadth-first Search
- Depth-first Search

## Explain

See solutions.

## Code

### Solution 1 - BFS

Normal `BFS`, collect items of each level from right, for every first node, put its value to `res`.

```java
/**
 * Type: BFS
 * Time: n
 * Space: n
 */
class Solution {
  public List<Integer> rightSideView(TreeNode root) {
      List<Integer> res = new ArrayList<>();
      if (root == null) {
          return res;
      }
      
      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);
      
      while (!queue.isEmpty()) {
          int size = queue.size();
          for (int i = 0; i < size; i++) {
              TreeNode cur = queue.poll();
              if (i == 0) {
                  res.add(cur.val);
              }
              if (cur.right != null) {
                  queue.offer(cur.right);
              }
              if (cur.left != null) {
                  queue.offer(cur.left);
              }
          }
      }
      
      return res;
  }
}
```

### Solution 2 - DFS

Normal `DFS` from right, collect node value when reach to deeper level.

```java
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
```