/**
 * Three types of combination:
 * 1. "" with any palindrome;
 * 2. substring palindrome to the left with another string equals to its reversed right part; 
 * 3. substring palindrome to the right with another string equals to its reversed left part.
 */

/**
 * Type: Trie
 * Time: n*k*k
 * Space: n
 * 
 * //     ab|ddd  ba
 * ---------Trie-----------
 * // ba  ddd|ab
 * // abcd ""|dcba
 */
public class PalindromePairs_Trie {
    private class TrieNode {
        Map<Character, TrieNode> map;
        int index;
        List<Integer> list;

        TrieNode() {
            map = new HashMap<>();
            index = -1;
            list = new ArrayList<>();
        }
    }

    TrieNode root;

    // k^2
    private void insert(String s, int index) {
        TrieNode cur = root;
        for (int i = s.length() - 1; i >= 0; i--) { // k
            char c = s.charAt(i);
            if (!cur.map.containsKey(c)) {
                cur.map.put(c, new TrieNode());
            }
            if (isPalindrome(s, 0, i)) { // k
                cur.list.add(index); // [dddd](b)a
            }
            cur = cur.map.get(c);
        }
        cur.index = index;
        cur.list.add(index); // "" + abcd
    }

    // k^2
    private void search(String s, int index, List<List<Integer>> res) {
        TrieNode cur = root;
        for (int i = 0; i < s.length(); i++) { // k
            char c = s.charAt(i);
            if (cur.index >= 0 && cur.index != index && isPalindrome(s, i, s.length() - 1)) { // k
                res.add(Arrays.asList(index, cur.index)); // ab|ddd + ba
            }
            if (!cur.map.containsKey(c)) {
                return;
            }
            cur = cur.map.get(c);
        }

        for (int i : cur.list) {
            if (index == i) continue;
            res.add(Arrays.asList(index, i)); // abcd (s) + dddd|cba (Trie)
        }
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if (words == null || words.length == 0) {
            return res;
        }

        root = new TrieNode();
        // n*k^2
        for (int i = 0; i < words.length; i++) {
            insert(words[i], i);
        }

        // n*k^2
        for (int i = 0; i < words.length; i++) { // n
            search(words[i], i, res);
        }

        return res;
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePairs_Trie so = new PalindromePairs_Trie();
        String[] words = new String[]{"abcd","dcba","lls","s","sssll"};
        List<List<Integer>> res = so.palindromePairs(words);
        System.out.println(res);
    }
}

/**
 * Type: HashMap
 * Time: n*k*k
 * Space: n
 * 
 * //     ab|ddd  ba
 * // ba  ddd|ab
 * // abcd dcba
 */
class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if (words == null || words.length == 0) {
            return res;
        }
        
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        
        for (int i = 0; i < words.length; i++) { // n
            String cur = words[i];
            for (int cut = 0; cut <= cur.length(); cut++) { // k
                String s1 = cur.substring(0, cut);
                String s2 = cur.substring(cut);
                if (isPalindrome(s1)) {
                    String curRight = reverseStr(s2);
                    if (map.containsKey(curRight) && map.get(curRight) != i) { // k
                        res.add(Arrays.asList(map.get(curRight), i));
                    }
                }
                
                if (s2.length() != 0 && isPalindrome(s2)) {
                    String curLeft = reverseStr(s1);
                    if (map.containsKey(curLeft) && map.get(curLeft) != i) {
                        res.add(Arrays.asList(i, map.get(curLeft)));
                    }
                }
            }
        }
        
        return res;
    }
    
    private String reverseStr(String s) {
        return new StringBuilder(s).reverse().toString();
    }
    
    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
