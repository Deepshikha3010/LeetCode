class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) {
            return A;
        }
        
        int height = A.length;
        int width = A[0].length;
        
        for (int i = 0; i < height; i++) {
            int start = 0, end = width - 1;
            while (start < end) {
                swap(A[i], start, end);
                start++;
                end--;
            }
        }
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int c = A[i][j];
                if (c == 1) {
                    A[i][j] = 0;
                } else {
                    A[i][j] = 1;
                }
            }
        }
        
        return A;
    }
    
    private void swap(int[] A, int start, int end) {
        int temp = A[start];
        A[start] = A[end];
        A[end] = temp;
    }
}