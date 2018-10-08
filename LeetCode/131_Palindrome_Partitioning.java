class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        
        boolean[][] f = getPalindrome(s);
        helper(s, 0, new ArrayList<>(), result, f);
        
        return result;
    }
    
    private void helper(String s, int index, List<String> record, List<List<String>> result, boolean[][] f) {
        if (index >= s.length()) {
            result.add(new ArrayList<>(record));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (f[index][i]) {
                String sub = s.substring(index, i + 1);
                record.add(sub);
                helper(s, i + 1, record, result, f);
                record.remove(record.size() - 1);
            }
        }
    }
    
    private boolean[][] getPalindrome(String s) {
        int len = s.length();
        boolean[][] f = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            f[i][i] = true;
        }
        for (int i = 0; i + 1 < len; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                f[i][i + 1] = true;
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j + 1 < i; j++) {
                if (s.charAt(i) == s.charAt(j) && f[j + 1][i - 1]) {
                    f[j][i] = true;
                }
            }
        }
        return f;
    }
}