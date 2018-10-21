class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int height = grid.length;
        int width = grid[0].length;
        
        int[][] f = new int[height][width];
        f[0][0] = grid[0][0];
        
        for (int i = 1; i < height; i++) {
            int cur = grid[i][0];
            f[i][0] = f[i - 1][0] + cur;
        }
        
        for (int i = 1; i < width; i++) {
            int cur = grid[0][i];
            f[0][i] = f[0][i - 1] + cur;
        }
        
        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                int cur = grid[i][j];
                f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + cur;
            }
        }
        
        return f[height - 1][width - 1];
    }
}