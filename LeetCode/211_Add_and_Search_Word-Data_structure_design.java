class WordDictionary {
    
    private class TrieNode {
        char c;
        Map<Character, TrieNode> map;
        boolean isEnd;
        
        TrieNode(char c) {
            this.c = c;
            this.map = new HashMap<>();
            this.isEnd = false;
        }
    }
    
    TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode('#');
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.map.containsKey(c)) {
                cur.map.put(c, new TrieNode(c));
            }
            cur = cur.map.get(c);
        }
        cur.isEnd = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(root, word);
    }
    
    private boolean search(TrieNode node, String s) {
        if (node == null) {
            return false;
        }
        if (s.length() == 0) {
            return node.isEnd;
        }
        char c = s.charAt(0);
        if (c == '.') {
            for (TrieNode next : node.map.values()) {
                if (search(next, s.substring(1))) {
                    return true;
                }
            }
            return false;
        } else {
            return search(node.map.get(c), s.substring(1));
        }
        
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */