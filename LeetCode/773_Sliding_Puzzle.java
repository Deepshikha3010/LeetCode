/**
 * Type: BFS
 * Time: (n*m)!
 * Space: (n*m)!
 */
class Solution {
    private class Entry {
        int y, x;
        String state;
        
        Entry(int y, int x, String state) {
            this.y = y;
            this.x = x;
            this.state = state;
        }
    }
    
    public int slidingPuzzle(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return 0;
        }
        
        int[][] target = new int[][]{{1,2,3}, {4,5,0}};
        int[] h = new int[]{0 , 1, 0, -1};
        int[] v = new int[]{1, 0 , -1, 0};
        
        String start = "";
        String goal = "";
        Entry e = new Entry(-1, -1 , "");
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                start += Integer.toString(board[i][j]);
                goal += Integer.toString(target[i][j]);
                if (board[i][j] == 0) {
                    e.y = i;
                    e.x = j;
                }
            }
        }
        
        if (start.equals(goal)) {
            return 0;
        }
        
        e.state = start;
        Set<String> set = new HashSet<>();
        set.add(start);
        Queue<Entry> queue = new LinkedList<>();
        queue.offer(e);
        
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int k = 0; k < size; k++) {
                Entry cur = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int newY = cur.y + h[i];
                    int newX = cur.x + v[i];
                    if (inBound(board, newY, newX)) {
                        String next = swap(board, cur, newY, newX);
                        if (set.contains(next)) continue;
                        if (next.equals(goal)) {
                            return count;
                        }
                        queue.offer(new Entry(newY, newX, next));
                        set.add(next);
                    }
                }
            }
        }
        
        return -1;
    }
    
    private String swap(int[][] board, Entry e, int newY, int newX) {
        char[] cs = e.state.toCharArray();
        int start = e.y * board[0].length + e.x;
        int end = newY * board[0].length + newX;
        char temp = cs[start];
        cs[start] = cs[end];
        cs[end] = temp;
        return String.valueOf(cs);
    }
    
    private boolean inBound(int[][] board, int y, int x) {
      return y >= 0 && y < board.length && x >= 0 && x < board[0].length;
    }
}