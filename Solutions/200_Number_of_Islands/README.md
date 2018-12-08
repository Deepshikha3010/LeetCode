# [200. Number of Islands](https://leetcode.com/problems/number-of-islands/)

## Type

- Depth-first Search
- Breadth-first Search
- Union Find

## Explain

Recommand to use BFS, since if depth search goes too deep, it will cause stack overflow.

## Code

### Solution 1 - DFS

```java
/**
 * Type: DFS
 * Time: m*n
 * Space: m*n (worst case)
 */
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        
        return count;
    }
    
    private final int[] dx = new int[]{0, 1, 0, -1};
    private final int[] dy = new int[]{1, 0, -1, 0};
    
    private void dfs(char[][] grid, int y, int x) {
        grid[y][x] = '0';
        
        for (int i = 0; i < 4; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];
            if (inBound(grid, newY, newX) && grid[newY][newX] == '1') {
                dfs(grid, newY, newX);
            }
        }
    }
    
    private boolean inBound(char[][] grid, int y, int x) {
        return y >= 0 && y < grid.length && x >= 0 && x < grid[0].length;
    }
}
```

### Solution 2 - BFS

```java
/**
 * Type: BFS
 * Time: m*n
 * Space: m*n (worst case)
 */
class Solution {
    private class Entry {
        int y, x;
        
        Entry(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j);
                }
            }
        }
        
        return count;
    }
    
    private final int[] dx = new int[]{0, 1, 0, -1};
    private final int[] dy = new int[]{1, 0, -1, 0};
    
    private void bfs(char[][] grid, int y, int x) {
        Queue<Entry> queue = new LinkedList<>();
        queue.offer(new Entry(y, x));
        
        grid[y][x] = '0';
        
        while (!queue.isEmpty()) {
            Entry cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newY = cur.y + dy[i];
                int newX = cur.x + dx[i];
                if (inBound(grid, newY, newX) && grid[newY][newX] == '1') {
                    grid[newY][newX] = '0'; // Should change to '0' when put into queue.
                    queue.offer(new Entry(newY, newX));
                }
            }
        }
    }
    
    private boolean inBound(char[][] grid, int y, int x) {
        return y >= 0 && y < grid.length && x >= 0 && x < grid[0].length;
    }
}
```

### Solution 3 - Union Find

```java
/**
 * Type: Union Find
 * Time: n
 * Space: n
 */
class Solution {
    private class UnionFind {
        int[] father;
        int m, n;
        int count;
        
        UnionFind(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            father = new int[m * n];
            count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        count++;
                    }
                    father[i * n + j] = i * n + j;
                }
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
            if(root_a != root_b) {
                father[root_a] = root_b;
                count--;
            }
        }
    }
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        
        UnionFind uf = new UnionFind(grid);
        
        int[] dy = new int[]{0, 1, 0, -1};
        int[] dx = new int[]{1, 0, -1, 0};

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    for (int k = 0; k < 4; k++) {
                        int newY = i + dy[k];
                        int newX = j + dx[k];
                        if (inBound(grid, newY, newX) && grid[newY][newX] == '1') {
                            uf.connect(i * n + j, newY * n + newX);
                        }
                    }
                }
            }
        }
        
        return uf.count;
    }
    
    private boolean inBound(char[][] grid, int y, int x) {
        return y >= 0 && y < grid.length && x >= 0 && x < grid[0].length;
    }
}
```