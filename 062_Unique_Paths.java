/**
 * Matrix DP: 先处理f[0][i]与f[j][0]的状态
 * 
 * Solution: 时间复杂度n2, 空间复杂度n2
 */

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] f = new int[m][n];
        for(int i = 0; i < m; i++){
            f[i][0] = 1;
        }
        for(int i = 0; i < n; i++){
            f[0][i] = 1;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }
}