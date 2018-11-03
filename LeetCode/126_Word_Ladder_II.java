class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return res;
        }
        
        set.add(beginWord);
        
        Map<String, List<String>> map = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();
        List<String> record = new ArrayList<>();
        
        bfs(beginWord, endWord, set, map, distance);
        // dfs(endWord, beginWord, map, distance, res, record);
        dfs(res, record, endWord, beginWord, distance, map);
        
        return res;
    }
    
    void dfs(List<List<String>> ladders, List<String> path, String crt,
            String start, Map<String, Integer> distance,
            Map<String, List<String>> map) {
        path.add(crt);
        if (crt.equals(start)) {
            Collections.reverse(path);
            ladders.add(new ArrayList<String>(path));
            Collections.reverse(path);
        } else {
            for (String next : map.get(crt)) {
                if (distance.containsKey(next) && distance.get(crt) == distance.get(next) + 1) { 
                    dfs(ladders, path, next, start, distance, map);
                }
            }           
        }
        path.remove(path.size() - 1);
    }
    
    private void dfs(String startWord, String endWord, Map<String, List<String>> map, Map<String, Integer> distance, List<List<String>> res, List<String> record) {
        record.add(startWord);
        if (startWord.equals(endWord)) {
            List<String> tmp = new ArrayList<>(record);
            Collections.reverse(tmp);
            res.add(tmp);
        } else {
            int level = distance.get(startWord);
            List<String> nexts = map.get(startWord);
            for (String next : nexts) {
                if (distance.containsKey(next) && distance.get(next) == level - 1) {
                    System.out.print(next + ",");
                    dfs(next, endWord, map, distance, res, record);
                }
            }
        }
        record.remove(record.size() - 1);
    }
    
    private void bfs(String beginWord, String endWord, Set<String> set, Map<String, List<String>> map, Map<String, Integer> distance) {
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        distance.put(beginWord, 0);
        int count = 0;
        for (String s : set) {
            map.put(s, new ArrayList<>());
        }
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                List<String> nexts = getNexts(cur, set);
                for (String next : nexts) {
                    map.get(cur).add(next);
                    if (!distance.containsKey(next)) {
                        // System.out.print(next + ",");
                        distance.put(next, count);
                        queue.add(next);
                    }
                }
            }
            // System.out.println("-------------");
        }
    }
    
    private List<String> getNexts(String cur, Set<String> set) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < cur.length(); i++) {
            char[] cs = cur.toCharArray();
            char tmp = cs[i];
            for (int j = 0; j < 26; j++) {
                char c = (char)(j + 'a');
                if (c != tmp) {
                    cs[i] = c;
                    String s = new String(cs);
                    if (set.contains(s)) {
                        res.add(s);
                    }
                }
            }
        }
        return res;
    }
}