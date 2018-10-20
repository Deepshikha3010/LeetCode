class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        
        int height = matrix.length;
        int width = matrix[0].length;
        
        boolean h = false, v = false;
        boolean origin = matrix[0][0] == 0 ? true : false;
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int cur = matrix[i][j];
                if (cur == 0) {
                    if (i == 0 || j == 0) {
                        if (i == 0 && j == 0) {
                            h = true;
                            v = true;
                        } else if (i == 0) {
                            v = true;
                        } else if (j == 0) {
                            h = true;
                        }
                    } else {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }
        }
        
        for (int i = 1; i < height; i++) {
            int cur = matrix[i][0];
            if (cur == 0) {
                for (int j = 1; j < width; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        for (int i = 1; i < width; i++) {
            int cur = matrix[0][i];
            if (cur == 0) {
                for (int j = 1; j < height; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        
        if (h) {
            for (int i = 0; i < height; i++) {
                matrix[i][0] = 0;               
            }
        }
        
        if (v) {
            for (int i = 0; i < width; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}