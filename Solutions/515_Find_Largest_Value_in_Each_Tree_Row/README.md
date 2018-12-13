# [515. Find Largest Value in Each Tree Row](https://leetcode.com/problems/find-largest-value-in-each-tree-row/)

## Type

- Tree
- Breadth-first Search

## Explain

Use normal level based tree BFS and record the max value of each level.

## Code

### Solution 1 - BFS

```java
/**
 * Type: Tree
 * Time: n
 * Space: logn (height, wosrst can be n)
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                max = Math.max(cur.val, max);
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            res.add(max);
        }
        
        return res;
    }
}
```