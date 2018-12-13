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
        boolean[][] map = new boolean[m][n];
        
        // Horizontal Pacific
        for (int i = 0; i < n; i++) {
            bfs(matrix, 0, i, map);
        }
        
        // Vertical Pacific
        for (int i = 0; i < m; i++) {
            bfs(matrix, i, 0, map);
        }
        
        boolean[][] visited = new boolean[m][n];
        // Horizontal Altantic
        for (int i = 0; i < n; i++) {
            getPos(matrix, m - 1, i, map, visited, res);
        }
        
        // Vertical Altanic
        for (int i = 0; i < m; i++) {
            getPos(matrix, i, n - 1, map, visited, res);
        }
        
        return res;
    }
    
    private final int[] h = new int[]{0, 1, 0, -1};
    private final int[] v = new int[]{1, 0, -1, 0};
    
    private void getPos(int[][] matrix, int y, int x, boolean[][] map, boolean[][] visited, List<int[]> res) {
        if (visited[y][x]) return;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y, x});
        visited[y][x] = true;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (map[cur[0]][cur[1]]) {
                res.add(new int[]{cur[0], cur[1]});
            }
            for (int i = 0; i < 4; i++) {
                int newY = cur[0] + h[i];
                int newX = cur[1] + v[i];
                if (inBound(matrix, newY, newX) && !visited[newY][newX] && matrix[cur[0]][cur[1]] <= matrix[newY][newX]) {
                    queue.offer(new int[]{newY, newX});
                    visited[newY][newX] = true;
                }
            }
        }
    }
    
    private void bfs(int[][] matrix, int y, int x, boolean[][] map) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y, x});
        map[y][x] = true;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newY = cur[0] + h[i];
                int newX = cur[1] + v[i];
                if (inBound(matrix, newY, newX) && !map[newY][newX] && matrix[cur[0]][cur[1]] <= matrix[newY][newX]) {
                    map[newY][newX] = true;
                    queue.offer(new int[]{newY, newX});
                }
            }
        }
    }
    
    private boolean inBound(int[][] matrix, int y, int x) {
        return y >= 0 && y < matrix.length && x >= 0 && x < matrix[0].length;
    }
    
}