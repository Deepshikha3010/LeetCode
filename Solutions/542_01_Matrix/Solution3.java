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