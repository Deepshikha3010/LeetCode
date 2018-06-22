/**
 * BFS
 * 注意：符合条件的next point进入queue之前先修改为 '0'，防止相邻先加入queue的元素重复计算。
 * 
 * 时间复杂度mn，空间复杂度mn
 */

/**Solution 1 Iteration + Point class */
class Solution {
    private class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int height = grid.length, width = grid[0].length;
        int amount = 0;
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if(grid[i][j] == '1'){
                    amount++;
                    helper(grid, new Point(i, j));
                }
            }
        }
        return amount;
    }
    
    private void helper(char[][] grid, Point p){
        Queue<Point> queue = new LinkedList<>();
        grid[p.x][p.y] = '0';
        queue.offer(p);
        int[] xCord = new int[]{0, 1, -1, 0};
        int[] yCord = new int[]{1, 0, 0, -1};
        while(!queue.isEmpty()){
            Point cur = queue.poll();
            for(int i = 0; i < 4; i++){
                Point next = new Point(cur.x + xCord[i], cur.y + yCord[i]);
                if(inBoundary(grid, next) && grid[next.x][next.y] == '1'){
                    queue.offer(next);
                    grid[next.x][next.y] = '0';
                }
            }
        }
    }
    
    private boolean inBoundary(char[][]grid, Point p){
        int height = grid.length;
        int width = grid[0].length;
        return p.x >= 0 && p.x < height && p.y >= 0 && p.y < width;
    }
}

/**Solution 2 Recursion */
class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int result = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    helper(grid, i, j);
                    result++;
                }
            }
        }
        return result;
    }
    
    private void helper(char[][] grid, int x, int y){
        int[] xCord = new int[]{-1, 0, 1, 0};
        int[] yCord = new int[]{0, -1, 0, 1};
        grid[x][y] = '0';
        for(int i = 0; i < xCord.length; i++){
            int m = x + xCord[i];
            int n = y + yCord[i];
            if(isInBound(grid, m, n) && grid[m][n] == '1'){
                helper(grid, m, n);
            }
        }
    }
    
    private boolean isInBound(char[][] grid, int i, int j){
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }
}
