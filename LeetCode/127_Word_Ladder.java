class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0) {
            return 0;
        }
        wordList.add(beginWord);
        Map<String, List<String>> map = buildMap(wordList);
        
        int steps = 0;
        Queue<String> queue = new LinkedList<>();
        Set<String> record = new HashSet<>();
        
        queue.offer(beginWord);
        record.add(beginWord);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            steps++;
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(endWord)) {
                    return steps;
                }
                List<String> nexts = map.get(cur);
                for (String next : nexts) {
                    if (record.contains(next)) {
                        continue;
                    }
                    queue.offer(next);
                    record.add(next);
                }
            }
        }
        return 0;
    }
    
    private Map<String, List<String>> buildMap(List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Map<String, List<String>> map = new HashMap<>();
        for (String word : wordList) {
            List<String> list = findNeighbors(word, set);
            map.put(word, list);
        }
        return map;
    }
    
    private List<String> findNeighbors(String word, Set<String> set) {
        List<String> list = new ArrayList<>();
        char[] cs = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < 26; j++) {
                char c = (char)(j + 'a');
                char cur = cs[i];
                if (c != cur) {
                    cs[i] = c;
                    String newWord = new String(cs);
                    if (set.contains(newWord)) {
                        list.add(newWord);
                    }
                    cs[i] = cur;
                }
            }
        }
        return list;
    }
}