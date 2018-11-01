class Solution {
    private class UF {
        Map<String, String> map;
        
        UF(Set<String> set) {
            this.map = new HashMap<>();
            for (String s : set) {
                map.put(s, s);
            }
        }
        
        String find(String s) {
            if (map.get(s).equals(s)) {
                return s;
            }
            map.put(s, find(map.get(s)));
            return map.get(s);
        }
        
        void connect(String a, String b) {
            String root_a = find(a);
            String root_b = find(b);
            if (!root_a.equals(root_b)) {
                map.put(root_a, root_b);
            }
        }
    }
    
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) {
            return false;
        }
        
        Set<String> set = new HashSet<>();
        for (String s : words1) {
            set.add(s);
        }
        for (String s : words2) {
            set.add(s);
        }
        for (String[] p : pairs) {
            set.add(p[0]);
            set.add(p[1]);
        }
        
        UF uf = new UF(set);
        
        for (String[] p : pairs) {
            if (set.contains(p[0]) && set.contains(p[1])) {
                uf.connect(p[0], p[1]);
            }
        }
        
        int len = words1.length;
        for (int i = 0; i < len; i++) {
            String w1 = words1[i];
            String w2 = words2[i];
            
            if (w1.equals(w2)) {
                continue;
            }
            
            String root1 = uf.find(w1);
            String root2 = uf.find(w2);
            if (!root1.equals(root2)) {
                return false;
            }
        }
        
        return true;
    }
}