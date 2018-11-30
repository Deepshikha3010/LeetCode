class Solution {
  public double knightProbability(int N, int K, int r, int c) {
      double[][] f0 = new double[N][N];
      f0[r][c] = 1;
      
      int[][] d = new int[][]{{1, 2}, {-1, -2}, {1, -2}, {-1, 2}, {2, 1}, {-2, -1}, {2, -1}, {-2, 1}};
      
      for (int k = 0; k < K; k++) {
          double[][] f1 = new double[N][N];
          
          for (int i = 0; i < N; i++) {
              for (int j = 0; j < N; j++) {
                  for (int n = 0; n < 8; n++) {
                      int y = i + d[n][0];
                      int x = j + d[n][1];
                      
                      if (inBound(N, y, x)) {
                          f1[y][x] += f0[i][j];
                      }                
                  }
              }
          }
          f0 = f1;
      }
      
      double sum = 0;
      for (int i = 0; i < N; i++) {
          for (int j = 0; j < N; j++) {
              sum += f0[i][j];
          }
      }
      
      return sum / Math.pow(8.0, K);
  }
  
  private boolean inBound(int N, int y, int x) {
      return y >= 0 && y < N && x >= 0 && x < N;
  }
}