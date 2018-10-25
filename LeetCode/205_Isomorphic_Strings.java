class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s.length() == 0 && t.length() == 0) {
            return true;
        }
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        
        Map<Character, Character> mapS = new HashMap<>();
        Map<Character, Character> mapT = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (!mapS.containsKey(sc)) {
                mapS.put(sc, tc);
            } else if (mapS.get(sc) != tc) {
                return false;
            }
            if (!mapT.containsKey(tc)) {
                mapT.put(tc, sc);
            } else if (mapT.get(tc) != sc) {
                return false;
            }
        }
        
        return true;
    }
}