// rolling array: space 1
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        
        int height = matrix.length, width = matrix[0].length;
        int[][] f = new int[2][width];
        
        int max = 0;
        
        for (int i = 0; i < height; i++) {
            f[i % 2][0] = matrix[i][0] - '0';
            max = Math.max(f[i % 2][0], max);
            for (int j = 1; j < width; j++) {
                if (i > 0) {
                    if (matrix[i][j] - '0' > 0) {
                        f[i % 2][j] = Math.min(f[(i - 1) % 2][j - 1], Math.min(f[(i - 1) % 2][j], f[i % 2][j - 1])) + 1;
                    } else {
                        f[i % 2][j] = 0;
                    }
                } else {
                    f[i % 2][j] = matrix[i][j] - '0';
                }
                max = Math.max(max, f[i % 2][j]);
            }
        }
        
        return max * max;
    }
}

class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        
        int height = matrix.length, width = matrix[0].length;
        int[][] f = new int[height][width];
        
        int max = 0;
        
        for (int i = 0; i < height; i++) {
            f[i][0] = matrix[i][0] - '0';
            max = Math.max(f[i][0], max);
            for (int j = 1; j < width; j++) {
                if (i > 0) {
                    if (matrix[i][j] - '0' > 0) {
                        f[i][j] = Math.min(f[i - 1][j - 1], Math.min(f[i - 1][j], f[i][j - 1])) + 1;
                    } else {
                        f[i][j] = 0;
                    }
                } else {
                    f[i][j] = matrix[i][j] - '0';
                }
                max = Math.max(max, f[i][j]);
            }
        }
        
        return max * max;
    }
}