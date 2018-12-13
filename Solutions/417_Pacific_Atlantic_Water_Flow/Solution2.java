/**
 * Type: BFS
 * Time: m*n
 * Space: m*n
 */
class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        
        int m = matrix.length, n = matrix[0].length;
        
        Queue<int[]> pQueue = new LinkedList<>();
        Queue<int[]> aQueue = new LinkedList<>();
        boolean[][] pVisited = new boolean[m][n];
        boolean[][] aVisited = new boolean[m][n];
        
        for (int i = 0; i < n; i++) {
            pQueue.offer(new int[]{0, i});
            aQueue.offer(new int[]{m - 1, i});
            pVisited[0][i] = true;
            aVisited[m - 1][i] = true;
        }
        
        for (int i = 0; i < m; i++) {
            pQueue.offer(new int[]{i, 0});
            aQueue.offer(new int[]{i, n - 1});
            pVisited[i][0] = true;
            aVisited[i][n - 1] = true;
        }
        
        bfs(matrix, pQueue, pVisited);
        bfs(matrix, aQueue, aVisited);
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pVisited[i][j] && aVisited[i][j]) res.add(new int[]{i, j});
            }
        }
        
        return res;
    }
    
    private final int[] h = new int[]{0, 1, 0, -1};
    private final int[] v = new int[]{1, 0, -1, 0};
    
    private void bfs(int[][] matrix, Queue<int[]> queue, boolean[][] map) {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            map[cur[0]][cur[1]] = true;
            for (int i = 0; i < 4; i++) {
                int newY = cur[0] + h[i];
                int newX = cur[1] + v[i];
                if (inBound(matrix, newY, newX) && !map[newY][newX] && matrix[cur[0]][cur[1]] <= matrix[newY][newX]) {
                    queue.offer(new int[]{newY, newX});
                }
            }
        }
    }
    
    private boolean inBound(int[][] matrix, int y, int x) {
        return y >= 0 && y < matrix.length && x >= 0 && x < matrix[0].length;
    }
    
}