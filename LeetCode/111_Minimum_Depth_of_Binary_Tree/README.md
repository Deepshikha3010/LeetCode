# [111. Minimum Depth of Binary Tree](https://leetcode.com/problems/minimum-depth-of-binary-tree/)

## Type

- Binary Tree
- Breadth-first Search
- Depth-first Search
- Queue

## Explain

BFS has better performance than DFS in this case, since DFS requires to traverse all nodes but BFS will end at the minimum depth leaf node.

## Code

### Solution 1 - BFS

```java
/**
 * LeetCode: https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * Type: BFS
 * Time: n (worst)
 * Space: n
 */
class Solution {
  public int minDepth(TreeNode root) {
      if (root == null) {
          return 0;
      }
      
      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);
      int count = 1;
      
      while (!queue.isEmpty()) {
          int size = queue.size();
          for (int i = 0; i < size; i++) {
              TreeNode cur = queue.poll();
              if (cur.left == null && cur.right == null) {
                  return count;
              }
              if (cur.left != null) {
                  queue.offer(cur.left);
              }
              if (cur.right != null) {
                  queue.offer(cur.right);
              }
          }
          count++;
      }
      
      return count;
  }
}
```

### Solution 2 - DFS
```java
/**
 * LeetCode: https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * Type: DFS
 * Time: n
 * Space: n
 */
class Solution {
  private class Entry {
      TreeNode node;
      int level;
      
      Entry(TreeNode node, int level) {
          this.node = node;
          this.level = level;
      }
  }
  
  public int minDepth(TreeNode root) {
      if (root == null) {
          return 0;
      }
      
      Stack<Entry> stack = new Stack<>();
      stack.push(new Entry(root, 1));
      
      int min = Integer.MAX_VALUE;
      while (!stack.isEmpty()) {
          Entry cur = stack.pop();
          if (cur.node.left == null && cur.node.right == null) {
              min = Math.min(min, cur.level);
          }
          if (cur.node.left != null) {
              stack.push(new Entry(cur.node.left, cur.level + 1));
          }
          if (cur.node.right != null) {
              stack.push(new Entry(cur.node.right, cur.level + 1));
          }
      }
      
      return min;
  }
}
```