class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        
        int height = matrix.length;
        int width = matrix[0].length;
        
        int top = 0, bottom = height - 1, left = 0, right = width - 1;
        while(top < bottom && left < right) {
            for (int i = left; i < right; i++) {
                res.add(matrix[top][i]);
            }
            for (int i = top; i < bottom; i++) {
                res.add(matrix[i][right]);
            }
            for (int i = right; i > left; i--) {
                res.add(matrix[bottom][i]);
            }
            for (int i = bottom; i > top; i--) {
                res.add(matrix[i][left]);
            }
            left++;
            top++;
            right--;
            bottom--;
        }
        
        while(left < right && top == bottom) {
            res.add(matrix[top][left]);
            left++;
        }

        while(top < bottom && left == right) {
            res.add(matrix[top][left]);
            top++;
        }
        
        if (left == right && top == bottom) {
            res.add(matrix[top][left]);
        }
        
        return res;
    }
}