class Solution {
  private class Entry {
      int y, x;
      String s;
      
      Entry(String s, int y, int x) {
          this.s = s;
          this.y = y;
          this.x = x;
      }
  }
  
  public int slidingPuzzle(int[][] board) {
      if (board == null || board.length == 0 || board[0].length == 0) {
          return -1;
      }
      
      String start = "";
      String goal = "";
      int[] h = new int[]{0, 1, 0, -1};
      int[] v = new int[]{1, 0, -1, 0};
      
      Entry co = new Entry("", -1, -1);
      for (int i = 0; i < board.length; i++) {
          for (int j = 0; j < board[0].length; j++) {
              start += Integer.toString(board[i][j]);
              goal += Integer.toString(i * board[0].length + j + 1);
              if (board[i][j] == 0) {
                  co.y = i;
                  co.x = j;
              }
          }
      }
      
      goal = goal.substring(0, goal.length() - 1) + "0";
      
      if (goal.equals(start)) {
          return 0;
      }
      
      co.s = start;
      
      Set<String> set = new HashSet<>();
      set.add(start);
      
      Queue<Entry> queue = new LinkedList<>();
      queue.offer(co);
      
      int count = 0;
      while (!queue.isEmpty()) {
          int size = queue.size();
          count++;
          for (int i = 0; i < size; i++) {
              Entry cur = queue.poll();
              for (int k = 0; k < 4; k++) {
                  int newY = cur.y + h[k];
                  int newX = cur.x + v[k];
                  if (inBound(board, newY, newX)) {
                      String next = swap(board, cur, newY, newX);
                      if (set.contains(next)) {
                          continue;
                      }
                      if (next.equals(goal)) {
                          return count;
                      }
                      queue.offer(new Entry(next, newY, newX));
                      set.add(next);
                  }
              }
          }
      }
      
      return -1;
  }
  
  private String swap(int[][] board, Entry e, int newY, int newX) {
      char[] cs = e.s.toCharArray();
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