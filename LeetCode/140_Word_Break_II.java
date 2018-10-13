class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        
        Set<String> set = new HashSet<>(wordDict);
        Map<String, List<String>> map = new HashMap<>();
        
        List<String> res = helper(s, set, map, 0);
        
        return res;
    }
    
    private List<String> helper(String s, Set<String> set, Map<String, List<String>> map, int index) {
        if (map.containsKey(s.substring(index))) {
            return map.get(s.substring(index));
        }
        
        if (index >= s.length()) {
            return null;
        }
        
        List<String> res = new ArrayList<>();
        for (int i = index; i < s.length(); i++) {
            String sub = s.substring(index, i + 1);
            if (set.contains(sub)) {
                List<String> partRes = helper(s, set, map, i + 1);
                if (partRes == null) {
                    res.add(sub);
                    continue;
                }
                for (String str : partRes) {
                    res.add(sub + " " + str);
                }
            }
        }
        
        map.put(s.substring(index), res);
        return res;
    }
}