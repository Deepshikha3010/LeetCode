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
        
        // o(nkk)
        for (int i = 0; i < words.length; i++) {
            String cur = words[i];
            for (int cut = 0; cut <= cur.length(); cut++) {
                String s1 = cur.substring(0, cut);
                String s2 = cur.substring(cut);
                if (isPalindrome(s1)) {
                    String curRight = reverseStr(s2);
                    if (map.containsKey(curRight) && map.get(curRight) != i) {
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