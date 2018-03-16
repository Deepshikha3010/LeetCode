/**
 * BFS
 * 注意：符合条件的next point进入queue之前先修改为 '0'，防止相邻先加入queue的元素重复计算。
 * 
 * 时间复杂度mn，空间复杂度mn
 */

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