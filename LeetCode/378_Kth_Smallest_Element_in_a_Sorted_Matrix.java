class Solution {
  private class Entry implements Comparable<Entry>{
      int y, x;
      int val;
      
      Entry(int y, int x, int val) {
          this.y = y;
          this.x = x;
          this.val = val;
      }
      
      public int compareTo(Entry e) {
          return this.val - e.val;
      }
  }
  
  public int kthSmallest(int[][] matrix, int k) {
      if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || k == 0) {
          return -1;
      }
      
      PriorityQueue<Entry> pq = new PriorityQueue<>();
      for (int i = 0; i < matrix[0].length && i < k; i++) {
          pq.offer(new Entry(0, i, matrix[0][i]));
      }
      
      while (k-- > 1 && !pq.isEmpty()) {
          Entry e = pq.poll();
          if (e.y == matrix.length - 1) {
              continue;
          }
          pq.offer(new Entry(e.y + 1, e.x, matrix[e.y + 1][e.x]));
      }
      
      return pq.poll().val;
  }
}