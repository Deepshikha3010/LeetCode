class Solution {
    int[] h = new int[]{0, 1, 0, -1};
    int[] v = new int[]{1, 0, -1, 0};
    
    public void solve(char[][] board) {
        if (board == null || board.length <= 2 || board[0].length <= 2) {
            return;
        }
        int height = board.length;
        int width = board[0].length;
        
        for (int i = 0; i < height; i++) {
            helper(board, i, 0, '$');
            helper(board, i, width - 1, '$');
        }
        for (int i = 0; i < width; i++) {
            helper(board, 0, i, '$');
            helper(board, height - 1, i, '$');
        }
        
        for (int i = 1; i < height - 1; i++) {
            for (int j = 1; j < width - 1; j++) {
                helper(board, i, j, 'X');
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] == '$') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    private void helper(char[][] board, int y, int x, char c) {
        if (board[y][x] != 'O') {
            return;
        }
        
        board[y][x] = c;
        for (int i = 0; i < 4; i++) {
            int newY = y + h[i];
            int newX = x + v[i];
            if (inBound(board, newY, newX) && board[newY][newX] == 'O') {
                helper(board, newY, newX, c);
            }
        }
    }
    
    private boolean inBound(char[][] board, int y, int x) {
        return y >=0 && y < board.length && x >= 0 && x < board[0].length;
    }
}