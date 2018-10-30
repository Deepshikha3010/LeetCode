class Solution {
    private class TrieNode {
        char c;
        Map<Character, TrieNode> map;
        String word;
        
        TrieNode(char c) {
            this.c = c;
            this.map = new HashMap<>();
            this.word = null;
        }
    }
    
    private class Trie {
        TrieNode root;
        
        Trie() {
            this.root = new TrieNode('#');
        }
        
        void insert(String s) {
            TrieNode cur = root;
            for (char c : s.toCharArray()) {
                if (!cur.map.containsKey(c)) {
                    cur.map.put(c, new TrieNode(c));
                }
                cur = cur.map.get(c);
            }
            cur.word = s;
        }
    }
    
    int[] dy = new int[]{0, 1, 0, -1};
    int[] dx = new int[]{1, 0, -1, 0};
    
    private void search(char[][] board, int y, int x, TrieNode node, List<String> res) {
        char c = board[y][x];
        if (!node.map.containsKey(board[y][x])) {
            return;
        }
        
        TrieNode child = node.map.get(c);
        
        if (child.word != null) {
            res.add(child.word);
            child.word = null;
        }
        
        for (int i = 0; i < 4; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];
            if (inBound(board, newY, newX)) {
                board[y][x] = '#';
                search(board, newY, newX, child, res);
                board[y][x] = c;
            }
        }
    }
    
    private boolean inBound(char[][] board, int y, int x) {
        // return y < 0 || y >= board.length || x < 0 || x >= board[0].length;
        return y >= 0 && y < board.length && x >= 0 && x < board[0].length;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0 || board == null || board.length == 0 || board[0].length == 0) {
            return res;
        }
        
        Trie trie = new Trie();
        for (String s : words) {
            trie.insert(s);
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                search(board, i, j, trie.root, res);
            }
        }
        
        return res;
    }
}