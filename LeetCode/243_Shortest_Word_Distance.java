class Solution {
  public int shortestDistance(String[] words, String word1, String word2) {
      if (words == null || words.length == 0) {
          return -1;
      }
      
      int index1 = -1, index2 = -1;
      int min = Integer.MAX_VALUE;
      for (int i = 0; i < words.length; i++) {
          String cur = words[i];
          if (cur.equals(word1)) {
              index1 = i;
          } else if (cur.equals(word2)) {
              index2 = i;
          }
          
          if (index1 != -1 && index2 != -1) {
              min = Math.min(min, Math.abs(index1 - index2));
          }
      }
      
      return min;
  }
}