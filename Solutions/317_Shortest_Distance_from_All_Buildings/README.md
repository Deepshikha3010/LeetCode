# [317. Shortest Distance from All Buildings](https://leetcode.com/problems/shortest-distance-from-all-buildings/)

## Type

- Breadth-first Search

## Explain

For each `0` slot, count its distance sum to all buildings. If it cannot reach to all buildings, don't count it in the future minimum distance.

## Code

### Solution 1 - BFS (Brute Force)

```java
/**
 * Type: BFS
 * Time: m^2*n^2
 * Space: m*n
 */
class Solution {
    private class Entry {
        int y, x;
        int val;
        Entry(int y, int x, int val) {
            this.y = y;
            this.x = x;
            this.val = val;
        }
    }
    
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] map = new int[m][n];
        int[][] record;
        int count = 0;
        
        // m*n*m*n
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        
        // m*n*m*n
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    record = new int[m][n];
                    int num = bfs(grid, i, j, map, record);
                    if (num != count) grid[i][j] = 2;
                }
            }
        }
        
        // m*n*m*n
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    min = Math.min(min, map[i][j]);
                }
            }
        }
        
        return min != Integer.MAX_VALUE ? min : -1;
    }
    
    private final int[] h = new int[]{0, 1, 0, -1};
    private final int[] v = new int[]{1, 0, -1, 0};
    
    private int bfs(int[][] grid, int y, int x, int[][] map, int[][] record) {
        Queue<Entry> queue = new LinkedList<>();
        queue.offer(new Entry(y, x, 0));
        record[y][x] = 1;
        int count = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Entry cur = queue.poll();
                if (grid[cur.y][cur.x] == 1) {
                    map[y][x] += cur.val;
                    count++;
                    continue;
                }
                for (int k = 0; k < 4; k++) {
                    int newY = cur.y + h[k];
                    int newX = cur.x + v[k];
                    if (isValid(grid, newY, newX, record)) {
                        queue.offer(new Entry(newY, newX, cur.val + 1));
                        record[newY][newX] = 1;
                    }
                }
            }
        }
        
        return count;
    }
    
    private boolean isValid(int[][]grid, int y, int x, int[][] record) {
        return y >= 0 && y < grid.length && x >= 0 && x < grid[0].length && grid[y][x] != 2 && record[y][x] == 0;
    }
}
```