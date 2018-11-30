class AutocompleteSystem {
  class Entry {
      String s;
      Integer freq;

      Entry(String s, int freq) {
          this.s = s;
          this.freq = freq;
      }
  }

  class TrieNode {
      Map<Character, TrieNode> map;
      Map<String, Integer> freqMap;

      TrieNode() {
          map = new HashMap<>();
          freqMap = new HashMap<>();
      }
  }

  private TrieNode root;
  private TrieNode tempRoot;
  private StringBuilder sb;

  void insert(String s, int freq) {
      TrieNode cur = root;
      for (int i = 0; i < s.length(); i++) {
          char c = s.charAt(i);
          if (!cur.map.containsKey(c)) {
              cur.map.put(c, new TrieNode());
          }

          cur = cur.map.get(c);
          cur.freqMap.put(s, cur.freqMap.getOrDefault(s, 0) + freq);
      }
  }

  public AutocompleteSystem(String[] sentences, int[] times) {
      root = new TrieNode();
      tempRoot = root;
      sb = new StringBuilder();

      for (int i = 0; i < sentences.length; i++) {
          insert(sentences[i], times[i]);
      }
  }

  public List<String> input(char c) {
      List<String> res = new ArrayList<>();
      if (c == '#') {
          insert(sb.toString(), 1);
          sb = new StringBuilder();
          tempRoot = root;
          return res;
      }

      sb.append(c);

      if (!tempRoot.map.containsKey(c)) {
          tempRoot.map.put(c, new TrieNode());
          tempRoot = tempRoot.map.get(c);
          return res;
      }

      tempRoot = tempRoot.map.get(c);
      PriorityQueue<Entry> pq = new PriorityQueue<>((o1, o2) -> {
          if (o1.freq == o2.freq) {
              return o1.s.compareTo(o2.s);
          }
          return o2.freq - o1.freq;
      });

      for (String key : tempRoot.freqMap.keySet()) {
          pq.offer(new Entry(key, tempRoot.freqMap.get(key)));
      }

      for (int i = 0; i < 3 && !pq.isEmpty(); i++) {
          res.add(pq.poll().s);
      }
      return res;
  }
}

/**
* Your AutocompleteSystem object will be instantiated and called as such:
* AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
* List<String> param_1 = obj.input(c);
*/