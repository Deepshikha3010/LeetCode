class Solution {
    int count;
    
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int height = grid.length;
        int width = grid[0].length;
        
        int max = 0;
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == 1) {
                    count = 0;
                    helper(grid, i, j);
                    max = Math.max(max, count);
                }
                
            }
        }
        
        return max;
    }
    
    private void helper(int[][] grid, int y, int x) {
        grid[y][x] = 0;
        count++;
        int[] h = new int[]{0, 1, 0, -1};
        int[] v = new int[]{1, 0, -1, 0};
        
        for (int i = 0; i < 4; i++) {
            int newY = y + h[i];
            int newX = x + v[i];
            
            if (inBound(grid, newY, newX) && grid[newY][newX] == 1) {
                helper(grid, newY, newX);
            }
        }
    }
    
    private boolean inBound(int[][] grid, int y, int x) {
        return y >= 0 && y < grid.length && x >= 0 && x < grid[0].length;
    }
}