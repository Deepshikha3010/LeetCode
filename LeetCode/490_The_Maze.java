class Solution {
    int[] h = new int[]{0, 1, 0, -1};
    int[] v = new int[]{1, 0, -1, 0};
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0 || maze[0].length == 0) {
            return false;
        }
        
        return helper(maze, start, destination, new boolean[maze.length][maze[0].length]);
    }
    
    private boolean helper(int[][] maze, int[] start, int[] des, boolean[][] visited) {
        if (start[0] == des[0] && start[1] == des[1]) {
            return true;
        }
        
        int y = start[0];
        int x = start[1];
        
        if (!inBound(maze, y, x) || visited[y][x]) {
            return false;
        }
        
        visited[y][x] = true;
        
        for (int i = 0; i < 4; i++) {
            int Y = y, X = x;
            while (inBound(maze, Y + h[i], X + v[i])) {
                Y += h[i];
                X += v[i];
            }
            if (helper(maze, new int[]{Y, X}, des, visited)) {
                return true;
            }
        }
        
        return false;
    }
    
    private boolean inBound(int[][] maze, int y, int x) {
        return y >= 0 && y < maze.length && x >= 0 && x < maze[0].length && maze[y][x] == 0;
    }
}