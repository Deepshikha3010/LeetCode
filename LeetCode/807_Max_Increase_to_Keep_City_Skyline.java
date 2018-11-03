class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int[] h = new int[grid.length];
        int[] v = new int[grid[0].length];
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int cur = grid[i][j];
                h[i] = Math.max(h[i], cur);
                v[j] = Math.max(v[j], cur);
            }
        }
        
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int cur = grid[i][j];
                count += Math.min(h[i], v[j]) - cur;
            }
        }
        
        return count;
    }
}