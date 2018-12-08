/**
 * Type: BFS
 * Time: m*n
 * Space: m*n (worst case)
 */
class Solution {
    private class Entry {
        int y, x;
        
        Entry(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j);
                }
            }
        }
        
        return count;
    }
    
    private final int[] dx = new int[]{0, 1, 0, -1};
    private final int[] dy = new int[]{1, 0, -1, 0};
    
    private void bfs(char[][] grid, int y, int x) {
        Queue<Entry> queue = new LinkedList<>();
        queue.offer(new Entry(y, x));
        
        grid[y][x] = '0';
        
        while (!queue.isEmpty()) {
            Entry cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newY = cur.y + dy[i];
                int newX = cur.x + dx[i];
                if (inBound(grid, newY, newX) && grid[newY][newX] == '1') {
                    grid[newY][newX] = '0';
                    queue.offer(new Entry(newY, newX));
                }
            }
        }
    }
    
    private boolean inBound(char[][] grid, int y, int x) {
        return y >= 0 && y < grid.length && x >= 0 && x < grid[0].length;
    }
}