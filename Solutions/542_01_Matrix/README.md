# [542. 01 Matrix](https://leetcode.com/problems/01-matrix/)

## Type

- Breadth-first Search

## Explain

Despite of the pruning. Putting all start nodes into queue is more like a `BFS` than doing `BFS` starting from each `0`. The former can immediately cut down invalid traversal than the latter one.

DP: The distance of a cell from 0 can be calculated if we know the nearest distance for all the neighbours, in which case the distance is minimum distance of any neightbour + 1. Since we shuold check 4 adjacent cells, we have to have 2 sweeps, from top-left and bottom-right.

## Code

### Solution 1 - Brute Force BFS (TLE)

```java
/**
 * Type: BFS
 * Time: m^2*n^2 (worst case)
 * Space: m*n
 */
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return matrix;
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    bfs(matrix, i, j);
                }
            }
        }
        
        return matrix;
    }
    
    private final int[] h = new int[]{0, 1, 0, -1};
    private final int[] v = new int[]{1, 0, -1, 0};
    
    private void bfs(int[][] matrix, int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y, x});
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int count = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int newY = cur[0] + h[k];
                    int newX = cur[1] + v[k];
                    if (inBound(matrix, newY, newX) && matrix[newY][newX] != 0 && !visited[newY][newX]) {
                        matrix[newY][newX] = Math.min(matrix[newY][newX], count);
                        queue.offer(new int[]{newY, newX});
                        visited[newY][newX] = true;
                    }
                }
            }
        }
    }
    
    private boolean inBound(int[][] matrix, int y, int x) {
        return y >= 0 && y < matrix.length && x >= 0 && x < matrix[0].length;
    }
}
```

### Solution 2 - BFS (Pruning)

```java
/**
 * Type: BFS
 * Time: m*n (not garantee. worst case: (m*n)^2)
 * Space: m*n
 */
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return matrix;
        
        Queue<int[]> queue = new LinkedList<>();
        
        int[] h = new int[]{0, 1, 0, -1};
        int[] v = new int[]{1, 0, -1, 0};
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = Integer.MAX_VALUE;
                } else {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int k = 0; k < 4; k++) {
                int newY = cur[0] + h[k];
                int newX = cur[1] + v[k];
                if (inBound(matrix, newY, newX) && matrix[newY][newX] > matrix[cur[0]][cur[1]] + 1) {
                    matrix[newY][newX] = matrix[cur[0]][cur[1]] + 1;
                    queue.offer(new int[]{newY, newX});
                }
            }
        }
        
        return matrix;
    }
    
    private boolean inBound(int[][] matrix, int y, int x) {
        return y >= 0 && y < matrix.length && x >= 0 && x < matrix[0].length;
    }
}
```

### Solution 3 - DP

```java
/**
 * Type: DP
 * Time: m*n
 * Space: 1
 */
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return matrix;
        
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) continue;
                else {
                    matrix[i][j] = Integer.MAX_VALUE - 1;
                    if (i > 0) matrix[i][j] = Math.min(matrix[i - 1][j] + 1, matrix[i][j]);
                    if (j > 0) matrix[i][j] = Math.min(matrix[i][j - 1] + 1, matrix[i][j]);
                }
            }
        }
        
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i < m - 1) matrix[i][j] = Math.min(matrix[i + 1][j] + 1, matrix[i][j]);
                if (j < n - 1) matrix[i][j] = Math.min(matrix[i][j + 1] + 1, matrix[i][j]);
            }
        }
        
        return matrix;
    }
}
```