class Solution {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int height = grid.length;
        int width = grid[0].length;
        
        int sum = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int cur = grid[i][j];
                if (cur == 1) {
                    sum += helper(grid, i, j);
                }
            }
        }
        
        return sum;
    }
    
    private int helper(int[][] grid, int y, int x) {
        int[] h = new int[]{0, 1, 0, -1};
        int[] v = new int[]{-1, 0, 1, 0};
        
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            int newY = y + h[i];
            int newX = x + v[i];
            if (isWater(grid, newY, newX)) {
                sum++;
            }
        }
        
        return sum;
    }
    
    private boolean isWater(int[][] grid, int y, int x) {
        return (y < 0 || y >= grid.length || x < 0 || x >= grid[0].length) || grid[y][x] == 0;
    }
}