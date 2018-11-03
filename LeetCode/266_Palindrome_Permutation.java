class Solution {
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }
        
        int odd = 0;
        for (int count : map.values()) {
            if (count % 2 == 1) {
                odd++;
            }
            if (odd > 1) {
                return false;
            }
        }
        
        return true;
    }
}