class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        if (S == null || S.length() == 0) {
            return res;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            map.put(c, i);
        }
        
        int start = 0, end = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            end = Math.max(end, map.get(c));
            if (i == end) {
                res.add(end - start + 1);
                start = end + 1;
            }
        }
        
        return res;
    }
}
