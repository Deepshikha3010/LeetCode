public class Solution {
    /**
     * @param s: the list of binary string
     * @return: the max distance
     */
    private class TrieNode {
        TrieNode left, right;
        boolean isTail;
        
        TrieNode() {
            isTail = false;
        }
        
        void add(String s) {
            TrieNode cur = this;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '0') {
                    if (cur.left == null) {
                        cur.left = new TrieNode();
                    }
                    cur = cur.left;
                } else {
                    if (cur.right == null) {
                        cur.right = new TrieNode();
                    }
                    cur = cur.right;
                }
            }
            cur.isTail = true;
        }
    }
     
    private int ans;
    
    public int getAns(String[] s) {
        TrieNode root = new TrieNode();
        for (String str : s) {
            root.add(str);
        }
        ans = 0;
        findLongestSinglePath(root);
        return ans;
    }
    
    private int findLongestSinglePath(TrieNode node) {
        if (node == null) {
            return 0;
        }
        
        int left = findLongestSinglePath(node.left);
        int right = findLongestSinglePath(node.right);
        
        if ((node.left != null && node.right != null) || node.isTail) {
            ans = Math.max(ans, left + right);
        }
        
        return Math.max(right, left) + 1;
    }
}