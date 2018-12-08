# [261. Graph Valid Tree](https://leetcode.com/problems/graph-valid-tree/)

## Type

- Depth-first Search
- Union Find

## Explain

A valid tree has no loop. (Indegree of each node should be 1)

## Code

### Solution 1 - Union Find

Group connected nodes.

- One node should only join one group once, otherwise means there is a loop.
- All node should finally belong to one single group.

```java
/**
 * Type: Union Find
 * Time: E + V
 * Space: V
 */
class Solution {
    class UnionFind {
        int[] father;

        UnionFind(int n) {
            father = new int[n];
            for (int i = 0; i < n; i++) {
                father[i] = i;
            }
        }

        int find(int a) {
            if (father[a] == a) {
                return a;
            }
            return father[a] = find(father[a]);
        }

        void connect(int a, int b) {
            int root_a = find(a);
            int root_b = find(b);

            if (root_a != root_b) {
                father[root_a] = root_b;
            }
        }
    }
    
    public boolean validTree(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            
            if (uf.find(from) == uf.find(to)) {
                return false;
            }
            uf.connect(from, to);
        }
        
        int root = uf.find(0);
        for (int i = 1; i < n; i++) {
            if (uf.find(i) != root) {
                return false;
            }
        }
        
        return true;
    }
}
```

### Solution 2 - DFS

From node 0 treverse all nodes. If a node has been visited before, means there is a loop.

```java
/**
 * Type: DFS
 * Time: V + E
 * Space: V + E
 */
class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> map = new ArrayList<>();
        // V
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }
        // E
        for (int i = 0; i < edges.length; i++) {
            int v1 = edges[i][0];
            int v2 = edges[i][1];
            map.get(v1).add(v2);
            map.get(v2).add(v1);
        }
        
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        return dfs(map, visited, 0, -1) && visited.size() == n;
    }
    
    // V + E
    private boolean dfs(List<List<Integer>> map, Set<Integer> set, int cur, int pre) {
        List<Integer> list = map.get(cur);
        for (int i = 0; i < list.size(); i++) {
            int n = list.get(i);
            if (n == pre) continue;
            if (set.contains(n)) return false;
            set.add(n);
            if (!dfs(map, set, n, cur)) return false;
        }
        return true;
    }
}
```