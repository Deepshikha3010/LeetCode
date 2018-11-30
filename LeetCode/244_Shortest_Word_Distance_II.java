class WordDistance {
  Map<String, List<Integer>> map;

  public WordDistance(String[] words) {
      this.map = new HashMap<>();
      for (int i = 0; i < words.length; i++) {
          String s = words[i];
          if (!map.containsKey(s)) {
              map.put(s, new ArrayList<>());
          }
          map.get(s).add(i);
      }
  }
  
  public int shortest(String word1, String word2) {
      List<Integer> list1 = map.get(word1);
      List<Integer> list2 = map.get(word2);
      
      int index1 = 0, index2 = 0;
      int min = Integer.MAX_VALUE;
      while (index1 < list1.size() && index2 < list2.size()) {
          int n1 = list1.get(index1);
          int n2 = list2.get(index2);
          
          min = Math.min(min, Math.abs(n1 - n2));
          
          if (n1 > n2 || index1 >= list1.size()) {
              index2++;
          } else {
              index1++;
          }
      }
      
      return min;
  }
}

/**
* Your WordDistance object will be instantiated and called as such:
* WordDistance obj = new WordDistance(words);
* int param_1 = obj.shortest(word1,word2);
*/