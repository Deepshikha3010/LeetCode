# [130. Surrounded Regions](https://leetcode.com/problems/surrounded-regions/)

## Type

- Breadth-first Search
- Depth-first Search

## Explain

Change the 'O' adjacent to the bound to '#', then use standard 2d array `DFS` traverse.

## Code

### Solution 1 - DFS

```java
/**
 * Type: DFS
 * Time: m*n
 * Space: m*n
 */
class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length <= 2 || board[0].length <= 2) {
            return;
        }
        
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0, 'O', '#');
            }
            if (board[i][board[0].length - 1] == 'O') {
                dfs(board, i, board[0].length - 1, 'O', '#');
            }
        }
        
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i, 'O', '#');
            }
            if (board[board.length - 1][i] == 'O') {
                dfs(board, board.length - 1, i, 'O', '#');
            }
        }
        
        for (int i = 1; i < board.length - 1; i++) {
            for (int j = 1; j < board[0].length - 1; j++) {
                if (board[i][j] == 'O') {
                    dfs(board, i, j, 'O', 'X');
                }
            }
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '#') {
                    dfs(board, i, j, '#', 'O');
                }
            }
        }
    }
    
    private final int[] dx = new int[]{0, 1, 0, -1};
    private final int[] dy = new int[]{1, 0, -1, 0};
    
    private void dfs(char[][] grid, int y, int x, char source, char target) {
        grid[y][x] = target;
        
        for (int i = 0; i < 4; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];
            if (inBound(grid, newY, newX) && grid[newY][newX] == source) {
                dfs(grid, newY, newX, source, target);
            }
        }
    }
    
    private boolean inBound(char[][] grid, int y, int x) {
        return y >= 0 && y < grid.length && x >= 0 && x < grid[0].length;
    }
}
```
