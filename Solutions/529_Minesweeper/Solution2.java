/**
 * Type: BFS
 * Time: m*n
 * Space: m*n
 */
class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board == null || board.length == 0 || board[0].length == 0) return board;
        
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        
        Queue<int[]> queue = new LinkedList<>();
        Queue<int[]> temp;
        queue.offer(click);
        board[click[0]][click[1]] = 'B';
        
        int[] h = new int[]{0, 1, 0, -1, -1, 1, -1, 1};
        int[] v = new int[]{1, 0, -1, 0, -1, 1, 1, -1};
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            temp = new LinkedList<>();
            int count = 0;
            
            for (int i = 0; i < 8; i++) {
                int newY = cur[0] + h[i], newX = cur[1] + v[i];
                if (inBound(board, newY, newX)) {
                    if (board[newY][newX] == 'M') {
                        count++;
                    } else if (board[newY][newX] == 'E') {
                        temp.offer(new int[]{newY, newX});
                    }
                }
            }
            
            if (count != 0) {
                board[cur[0]][cur[1]] = (char)(count + '0');
            }
            while (count == 0 && !temp.isEmpty()) {
                int[] next = temp.poll();
                board[next[0]][next[1]] = 'B';
                queue.offer(next);
            }
        }
        
        return board;
    }
    
    private boolean inBound(char[][] board, int y, int x) {
        return y >= 0 && y < board.length && x >= 0 && x < board[0].length;
    }
}