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