# [323. Number of Connected Components in an Undirected Graph](https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/)

## Type

- Union Find
- Depth-first Search
- Graph

## Explain

<strong>DFS: </strong>

1. Build up a graph by `List<List<Integer>>`
2. Use a `visited` array to record visited connected components
3. Recursive `DFS`

<strong>Union Find: </strong>

Use a `parents` array to initiate each node as their own root node. Then connect nodes according to `edges`. Finally use a `HashSet` to count the root number.

## Code

### Solution 1 - DFS

```java
/**
 * Type: DFS
 * Time: E*V
 * Space: E*V + V
 */
class Solution {
    public int countComponents(int n, int[][] edges) {
        if (n <= 1) {
            return n;
        }
        List<List<Integer>> lists = new ArrayList<>();
        // V
        for (int i = 0; i < n; i++) {
            lists.add(new ArrayList<>());
        }
        // E
        for (int[] edge : edges) {
            lists.get(edge[0]).add(edge[1]);
            lists.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        int count = 0;
        // E*V
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(visited, i, lists);
            }
        }
        return count;
    }

    private void dfs (boolean[] visited, int index, List<List<Integer>> lists) {
        visited[index] = true;
        for (int i : lists.get(index)) {
            if (!visited[i]) {
                dfs(visited, i, lists);
            }
        }
    }
}
```

### Solution 2 - Union Find

```java
/**
 * Type: Union Find
 * Time: E
 * Space: V
 */
class Solution {
    private int[] parents;

    private int find(int n) {
        if (n == parents[n]) {
            return n;
        }
        return parents[n] = find(parents[n]);
    }

    public int countComponents(int n, int[][] edges) {
        if (n == 0) return 0;

        parents = new int[n];
        for (int i = 0; i < n; i++) parents[i] = i;

        // E
        for (int[] edge : edges) {
            int root1 = find(edge[0]);
            int root2 = find(edge[1]);
            if (root1 != root2) {
                parents[root1] = parents[root2];
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i : parents) {
            set.add(find(i));
        }

        return set.size();
    }
}
```