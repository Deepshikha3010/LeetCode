class Solution {
    private class TrieNode {
        char c;
        TrieNode[] map;
        
        TrieNode(char c) {
            this.c = c;
            this.map = new TrieNode[2];
        }
    }
    
    private class Trie {
        TrieNode root;
        
        Trie() {
            this.root = new TrieNode('#');
        }
        
        String insert(String s) {
            TrieNode cur = root;
            StringBuilder sb = new StringBuiler();
            boolean shouldCount = true;
            for (char c : s.toCharArray()) {
                int nc = c - '0';
                if (cur.map[nc] == null) {
                    shouldCount = false;
                    cur.map[nc] = new TrieNode(c);
                }
                if (shouldCount) {
                    
                }
                cur = cur.map[nc];
            }
            return count;
        }
    }
    
    
    public int findMaximumXOR(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        Trie t = new Trie();
        
        int max = 0;
        for (int num : nums) {
            String bnum = Integer.toBinaryString(num);
            String res = t.insert(bnum);
            max = Math.max(max, Integer.parseInt(res, 2););
        }
        
        return max;
    }
}