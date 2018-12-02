/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
  private class Pair {
      String key;
      int value;
      
      Pair(String key, int value) {
          this.key = key;
          this.value = value;
      }
  }
  
  private int match(String a, String b) {
      int count = 0;
      for (int i = 0; i < a.length(); i++) {
          if (a.charAt(i) == b.charAt(i)) {
              count++;
          }
      }
      
      return count;
  }
  
  public void findSecretWord(String[] wordlist, Master master) {
      for (int i = 0, x = 0; i < 10 && x < 6; i++) {
          HashMap<String, Integer> count = new HashMap<>();
          for (String w1 : wordlist) {
              for (String w2 : wordlist) {
                  if (match(w1, w2) == 0) {
                      count.put(w1, count.getOrDefault(w1, 0) + 1);
                  }
              }
          }
          
          Pair minimax = new Pair("", 1000);
          for (String w : wordlist) {
              if (count.getOrDefault(w, 0) < minimax.value) {
                  minimax.key = w;
                  minimax.value = count.getOrDefault(w, 0);
              }
          }
          x = master.guess(minimax.key);
          List<String> wordlist2 = new ArrayList<String>();
          for (String w : wordlist) {
              if (match(minimax.key, w) == x) {
                  wordlist2.add(w);
              }
          }
          wordlist = wordlist2.toArray(new String[wordlist2.size()]);
      }   
  }
}