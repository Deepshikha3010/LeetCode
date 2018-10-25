class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        if (strings == null || strings.length == 0) {
            return res;
        }
        
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            String key = helper(s);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        
        return new ArrayList<>(map.values());
    }
    
    private String helper(String s) {
        StringBuilder sb = new StringBuilder();
        char head = s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int dis =  c - head;
            char cur = mapping(dis);
            sb.append(cur);
        }
        return sb.toString();
    }
    
    private char mapping(int dis) {
        if (dis >= 0) {
            return (char)('a' + dis);
        }
        return (char)('a' + dis + 26);
    }
}