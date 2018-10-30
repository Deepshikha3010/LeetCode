class Trie {
    
    private class TrieNode {
        char c;
        boolean isEnd;
        Map<Character, TrieNode> map;
        
        TrieNode(char c) {
            this.c = c;
            this.map = new HashMap<>();
            this.isEnd = false;
        }
    }
    
    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        this.root = new TrieNode('#');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.map.containsKey(c)) {
                cur.map.put(c, new TrieNode(c));
            }
            cur = cur.map.get(c);
        }
        cur.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchNode(word);
        if (node == null) {
            return false;
        }
        return node.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (searchNode(prefix) != null) {
            return true;
        }
        return false;
    }
    
    private TrieNode searchNode(String s) {
        TrieNode cur = root;
        for (char c : s.toCharArray()) {
            if (!cur.map.containsKey(c)) {
                return null;
            }
            cur = cur.map.get(c);
        }
        return cur;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */