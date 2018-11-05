class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return false;
        }
        
        for (int i = 0; i < 9; i++) {
            boolean[] taken = new boolean[9];
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (taken[c - '1'] != false) {
                        return false;
                    }
                    taken[c - '1'] = true;
                }
            }
        }
        
        for (int i = 0; i < 9; i++) {
            boolean[] taken = new boolean[9];
            for (int j = 0; j < 9; j++) {
                char c = board[j][i];
                if (c != '.') {
                    if (taken[c - '1'] != false) {
                        return false;
                    }
                    taken[c - '1'] = true;
                }
            }
        }
        
        for (int i = 0; i < 9; i++) {
            boolean[] taken = new boolean[9];
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    char c = board[j + 3 * (i / 3)][k + 3 * (i % 3)];
                    if (c != '.') {
                        if (taken[c - '1'] != false) {
                            return false;
                        }
                        taken[c - '1'] = true;
                    }
                }
            }
        }
        
        return true;
    }
}