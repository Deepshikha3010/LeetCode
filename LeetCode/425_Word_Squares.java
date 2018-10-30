class Solution {
    private class TrieNode {
        char c;
        Map<Character, TrieNode> map;
        List<String> strings;
        
        TrieNode(char c) {
            this.c = c;
            this.map = new HashMap<>();
            this.strings = new ArrayList<>();
        }
    }
    
    private class Trie {
        TrieNode root;
        
        Trie(String[] words) {
            this.root = new TrieNode('#');
            for (String s : words) {
                insert(s);
            }
        }
        
        void insert(String s) {
            TrieNode cur = root;
            for (char c : s.toCharArray()) {
                cur.strings.add(s);
                if (!cur.map.containsKey(c)) {
                    cur.map.put(c, new TrieNode(c));
                }
                cur = cur.map.get(c);
            }
        }
        
        List<String> searchPrefix(String s) {
            TrieNode cur = root;
            for (char c : s.toCharArray()) {
                if (!cur.map.containsKey(c)) {
                    return new ArrayList<>();
                }
                cur = cur.map.get(c);
            }
            return cur.strings;
        }
    }
    
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();
        if (words == null || words.length == 0) {
            return res;
        }
        
        int len = words[0].length();
        Trie t = new Trie(words);
        List<String> record = new ArrayList<>();
        for (String s : words) {
            record.add(s);
            search(t, len, res, record);
            record.remove(record.size() - 1);
        }
        
        return res;
    }
    
    private void search(Trie t, int len, List<List<String>> res, List<String> record) {
        if (record.size() == len) {
            res.add(new ArrayList<>(record));
            return;
        }
        
        int index = record.size();
        StringBuilder sb = new StringBuilder();
        for (String s : record) {
            sb.append(s.charAt(index));
        }
        List<String> startWith = t.searchPrefix(sb.toString());
        for (String s : startWith) {
            record.add(s);
            search(t, len, res, record);
            record.remove(record.size() - 1);
        }
    }
}