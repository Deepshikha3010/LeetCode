class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int height = matrix.length, width = matrix[0].length;
        int y = height - 1, x = 0;
        
        while (y >= 0 && x < width) {
            int cur = matrix[y][x];
            if (cur < target) {
                x++;
            } else if (cur > target) {
                y--;
            } else {
                return true;
            }
        }
        
        return false;
    }
}