class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        
        int height = obstacleGrid.length;
        int width = obstacleGrid[0].length;
        int[][] f = new int[height][width];
        
        for (int i = 0; i < height; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            f[i][0] = 1;
        }
        
        for (int i = 0; i < width; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            f[0][i] = 1;
        }
        
        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                int cur = obstacleGrid[i][j];
                if (cur == 1) {
                    f[i][j] = 0;
                    continue;
                }
                int up = f[i - 1][j];
                int left = f[i][j - 1];
                f[i][j] = up + left;
            }
        }
        
        return f[height - 1][width - 1];
    }
}