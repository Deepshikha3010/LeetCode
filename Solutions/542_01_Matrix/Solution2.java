/**
 * Type: BFS
 * Time: m*n (worst case: (m*n)^2)
 * Space: m*n
 */
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return matrix;
        
        Queue<int[]> queue = new LinkedList<>();
        
        int[] h = new int[]{0, 1, 0, -1};
        int[] v = new int[]{1, 0, -1, 0};
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = Integer.MAX_VALUE;
                } else {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int k = 0; k < 4; k++) {
                int newY = cur[0] + h[k];
                int newX = cur[1] + v[k];
                if (inBound(matrix, newY, newX) && matrix[newY][newX] > matrix[cur[0]][cur[1]] + 1) {
                    matrix[newY][newX] = matrix[cur[0]][cur[1]] + 1;
                    queue.offer(new int[]{newY, newX});
                }
            }
        }
        
        return matrix;
    }
    
    private boolean inBound(int[][] matrix, int y, int x) {
        return y >= 0 && y < matrix.length && x >= 0 && x < matrix[0].length;
    }
}