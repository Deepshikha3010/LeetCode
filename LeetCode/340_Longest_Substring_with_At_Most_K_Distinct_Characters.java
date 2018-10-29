class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int left = 0, res = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (!map.containsKey(cur)) {
                map.put(cur, 0);
            }
            map.put(cur, map.get(cur) + 1);
            while (map.size() > k) {
                char c = s.charAt(left);
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    map.remove(c);
                }
                left++;
            }
            res = Math.max(res, i - left + 1);
        }
        
        return res;
    }
}