class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        
        int[] map = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map[c]++;
        }
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map[c] == 1) {
                return i;
            }
        }
        
        return -1;
    }
}