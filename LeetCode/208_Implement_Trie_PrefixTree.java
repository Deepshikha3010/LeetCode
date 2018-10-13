class Trie {
    private Node root;
    
    private class Node {
        char c;
        Map<Character, Node> nexts;
        boolean isEnd;
        
        Node() {
            this.nexts = new HashMap<>();
            this.isEnd = false;
        }
        
        Node(char c) {
            this.c = c;
            this.nexts = new HashMap<>();
            this.isEnd = false;
        }
    } 

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();  
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.nexts.containsKey(c)) {
                node.nexts.put(c, new Node(c));   
            }
            node = node.nexts.get(c);
        }
        node.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.nexts.containsKey(c)) {
                return false;
            }
            node = node.nexts.get(c);
        }
        return node.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!node.nexts.containsKey(c)) {
                return false;
            }
            node = node.nexts.get(c);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */