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
        
        // check "", o(nk)
        if (map.containsKey("")) {
            int index = map.get("");
            for (int i = 0; i < words.length; i++) {
                if (isPalindrome(words[i])) {
                    if (i == index) {
                        continue;
                    }
                    res.add(Arrays.asList(index, i));
                    res.add(Arrays.asList(i, index));
                }
            }
        }
        
        // check a and b palindrome for each other, o(nk)
        for (int i = 0; i < words.length; i++) {
            String cur = reverseStr(words[i]);
            if (map.containsKey(cur) && map.get(cur) != i) {
                res.add(Arrays.asList(i, map.get(cur)));
            }
        }
        
        // o(nkk)
        for (int i = 0; i < words.length; i++) {
            String cur = words[i];
            for (int cut = 1; cut < cur.length(); cut++) {
                if (isPalindrome(cur.substring(0, cut))) {
                    String curRight = reverseStr(cur.substring(cut));
                    if (map.containsKey(curRight) && map.get(curRight) != i) {
                        res.add(Arrays.asList(map.get(curRight), i));
                    }
                }
                
                if (isPalindrome(cur.substring(cut))) {
                    String curLeft = reverseStr(cur.substring(0, cut));
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