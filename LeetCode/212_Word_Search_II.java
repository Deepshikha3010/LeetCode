/**
 * Type: Trie + BFS
 * Time: m*n*k (k is word's average length)
 * Space: V
 */
class Solution {
    private class TrieNode {
        Map<Character, TrieNode> map;
        String word;
        
        TrieNode() {
            map = new HashMap<>();
            word = null;
        }
    }
    
    TrieNode root;
    int[] h = new int[]{0, 1, 0, -1};
    int[] v = new int[]{1, 0, -1, 0};
    
    private void insert(String s) {
        TrieNode cur = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!cur.map.containsKey(c)) {
                cur.map.put(c, new TrieNode());
            }
            cur = cur.map.get(c);
        }
        cur.word = s;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
            return res;
        }
        
        root = new TrieNode();
        for (String s : words) {
            insert(s);
        }
        
        // m*n*k
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                bfs(board, i, j, root, res);
            }
        }
        return res;
    }
    
    // k (average word length)
    private void bfs(char[][] board, int y, int x, TrieNode node, List<String> res) {
        char c = board[y][x];
        if (!node.map.containsKey(c)) {
            return;
        }
        
        if (node.map.get(c).word != null) {
            res.add(node.map.get(c).word);
            node.map.get(c).word = null;
        }
        
        board[y][x] = '#';
        
        for (int i = 0; i < 4; i++) {
            int newY = y + h[i];
            int newX = x + v[i];
            if (isValid(board, newY, newX)) {
                bfs(board, newY, newX, node.map.get(c), res);
            }
        }
        board[y][x] = c;
    }
    
    private boolean isValid(char[][] board, int y, int x) {
        return y >= 0 && y < board.length && x >= 0 && x < board[0].length && board[y][x] != '#';
    }
}