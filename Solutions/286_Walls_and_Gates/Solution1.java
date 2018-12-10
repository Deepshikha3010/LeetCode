/**
 * Type: BFS
 * Time: m*n
 * Space: m*n
 */
class Solution {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) return;
        
        int m = rooms.length;
        int n = rooms[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) queue.offer(new int[]{i, j});
            }
        }
        
        int[] h = new int[]{0, 1, 0, -1};
        int[] v = new int[]{1, 0, -1, 0};
        
        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            distance++;
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int newY = cur[0] + h[k];
                    int newX = cur[1] + v[k];
                    if (isValid(rooms, newY, newX)) {
                        rooms[newY][newX] = distance;
                        queue.offer(new int[]{newY, newX});
                    }
                }
            }
        }
    }
    
    private boolean isValid(int[][] rooms, int y, int x) {
        return y >= 0 && y < rooms.length && x >= 0 && x < rooms[0].length && rooms[y][x] == Integer.MAX_VALUE;
    }
}