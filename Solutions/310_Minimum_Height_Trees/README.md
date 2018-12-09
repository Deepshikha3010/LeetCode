# [310. Minimum Height Trees](https://leetcode.com/problems/minimum-height-trees/)

## Type

- Breadth-first Search

## Explain

A naive solution is try every node as root, and count their deepest depth.

<strong>Better solution:</strong>

Tree has no simple cycle. V = E + 1. As a result, there will be no more than 2 roots. Below is impossible:

```md
1 - 2
 \ /
  3
```

1. Build map (V -> E)
2. Find all leaves (only connect to 1 node)
3. BFS by level towards center(root)

## Code

### Solution 1 - BFS from root to leaves (Not Accepted)

```java
/**
 * Type: BFS
 * Time: V^2
 * Space: V
 */
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 0) return res;
        if (n == 1) {
            res.add(0);
            return res;
        }
        
        List<List<Integer>> map = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int v1 = edge[0];
            int v2 = edge[1];
            map.get(v1).add(v2);
            map.get(v2).add(v1);
        }
        
        int min = Integer.MAX_VALUE;
        int[] record = new int[n];
        for (int i = 0; i < n; i++) {
            int count = bfs(i, map);
            min = Math.min(min, count);
            record[i] = count;
        }
        
        for (int i = 0; i < record.length; i++) {
            if (record[i] == min) {
                res.add(i);
            }
        }
        
        return res;
    }
    
    private int bfs(int node, List<List<Integer>> map) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        
        queue.offer(node);
        set.add(node);
        
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                List<Integer> nexts = map.get(cur);
                for (int next : nexts) {
                    if (set.contains(next)) continue;
                    queue.offer(next);
                    set.add(next);
                }
            }
        }
        
        return count;
    }
}
```

### Solution 2 - BFS from leaves to roots

- The time complexity of `Set.remove()` is constant, so map uses `List<Set<Integer>>` instead of `List<List<Integer>`.
- Once reach a next level node, remove its edge with its parent node. When next's edge number equals 1, add it to queue.

```java
/**
 * Type: BFS
 * Time: V
 * Space: V
 */
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            List<Integer> res = new ArrayList<>(Arrays.asList(0));
            return res;
        }

        List<Set<Integer>> map = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            map.get(edge[1]).add(edge[0]);
            map.get(edge[0]).add(edge[1]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < map.size(); i++) {
            if (map.get(i).size() == 1) queue.offer(i);
        }
        
        while (!queue.isEmpty() && n > 2) {
            int size = queue.size();
            n -= size;
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                Set<Integer> nexts = map.get(cur);
                for (int next : nexts) {
                    map.get(next).remove(cur);
                    if (map.get(next).size() == 1) queue.offer(next);
                }
            }
        }
        
        return new ArrayList<>(queue);
    }
}
```