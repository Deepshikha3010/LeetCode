class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int len = matrix.length;
        int top = 0, left = 0;
        int bottom = len - 1, right = len - 1;
        int n = len;
        while(n > 0) {
            for (int i = 0; i < n - 1; i++) {
                int temp = matrix[top][left + i];
                matrix[top][left + i] = matrix[bottom - i][left];
                matrix[bottom - i][left] = matrix[bottom][right - i];
                matrix[bottom][right - i] = matrix[top + i][right];
                matrix[top + i][right] = temp;
            }
            top++;
            left++;
            right--;
            bottom--;
            n -= 2;
        }
    }
}