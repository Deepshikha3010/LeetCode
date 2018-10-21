class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        
        int top = 0, down = n - 1, left = 0, right = n - 1;
        
        int num = 1;
        while (top < down && left < right) {
            for (int i = left; i < right; i++) {
                res[top][i] = num;
                num++;
            }
            for (int i = top; i < down; i++) {
                res[i][right] = num;
                num++;
            }
            for (int i = right; i > left; i--) {
                res[down][i] = num;
                num++;
            }
            for (int i = down; i > top; i--) {
                res[i][left] = num;
                num++;
            }
            top++;
            down--;
            left++;
            right--;
        }
        
        if (num == n * n) {
            res[top][left] = n * n;
        }
        
        return res;
    }
}