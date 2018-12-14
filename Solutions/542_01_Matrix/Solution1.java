/**
 * Type: BFS
 * Time: m^2*n^2 (worst case)
 * Space: m*n
 */
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return matrix;
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    bfs(matrix, i, j);
                }
            }
        }
        
        return matrix;
    }
    
    private final int[] h = new int[]{0, 1, 0, -1};
    private final int[] v = new int[]{1, 0, -1, 0};
    
    private void bfs(int[][] matrix, int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y, x});
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int count = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int newY = cur[0] + h[k];
                    int newX = cur[1] + v[k];
                    if (inBound(matrix, newY, newX) && matrix[newY][newX] != 0 && !visited[newY][newX]) {
                        matrix[newY][newX] = Math.min(matrix[newY][newX], count);
                        queue.offer(new int[]{newY, newX});
                        visited[newY][newX] = true;
                    }
                }
            }
        }
    }
    
    private boolean inBound(int[][] matrix, int y, int x) {
        return y >= 0 && y < matrix.length && x >= 0 && x < matrix[0].length;
    }
}