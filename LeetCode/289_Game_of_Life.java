class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        
        int height = board.length;
        int width = board[0].length;
            
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int liveNum = surroundLive(board, i, j);
                if (board[i][j] == 1) {
                    if (liveNum < 2) {
                        board[i][j] = 2; // die
                    } else if (liveNum > 3) {
                        board[i][j] = 2;
                    }
                } else if (liveNum == 3) {
                    board[i][j] = 3; // live
                }
            }
        }
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int cur = board[i][j];
                if (cur == 2) {
                    board[i][j] = 0;
                } else if (cur == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }
    
    private int surroundLive(int[][] board, int y, int x) {
        int[] h = new int[]{0, 1, 0, -1, 1, -1, 1, -1};
        int[] w = new int[]{1, 0, -1, 0, -1, 1, 1, -1};
        
        int sum = 0;
        for (int i = 0; i < 8; i++) {
            int newY = y + h[i];
            int newX = x + w[i];
            if (inBound(board, newY, newX) && (board[newY][newX] == 1 || board[newY][newX] == 2)) {
                sum++;
            }
        }
        
        return sum;
    }
    
    private boolean inBound(int[][] board, int y, int x) {
        return y >= 0 && y < board.length && x >= 0 && x < board[0].length;
    }
}