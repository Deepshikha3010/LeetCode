class Solution {
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        
        int[] map = new int[26];
        boolean[] visited = new boolean[26];
        char[] res = new char[s.length()];
        int len = 0;
        
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        
        for (char c : s.toCharArray()) {
            map[c - 'a']--;
            if (visited[c - 'a']) {
                continue;
            }
            while (len > 0 && c < res[len - 1] && map[res[len - 1] - 'a'] > 0) {
                visited[res[--len] - 'a'] = false;
            }
            
            res[len++] = c;
            visited[c - 'a'] = true;
        }
        
        return new String(res, 0, len);
    }
}