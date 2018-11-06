class Solution {
    int[][] f;
    int[][] flag;
    
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int height = matrix.length;
        int width = matrix[0].length;
        f = new int[height][width];
        flag = new int[height][width];
        
        int max = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                search(matrix, i, j);
                max = Math.max(max, f[i][j]);
            }
        }
        
        return max;
    }
    
    int[] dy = new int[]{0, 1, 0, -1};
    int[] dx = new int[]{1, 0, -1, 0};
    
    private int search(int[][] matrix, int y, int x) {
        if (flag[y][x] == 1) {
            return f[y][x];
        }
        
        int max = 1;
        for (int i = 0; i < 4; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];
            if (inBound(matrix, newY, newX) && matrix[newY][newX] > matrix[y][x]) {
                max = Math.max(max, search(matrix, newY, newX) + 1);
            }
        }
        
        flag[y][x] = 1;
        f[y][x] = max;
        return max;
    }
    
    private boolean inBound(int[][] matrix, int y, int x) {
        return y >= 0 && y < matrix.length && x >= 0 && x < matrix[0].length;
    }
}