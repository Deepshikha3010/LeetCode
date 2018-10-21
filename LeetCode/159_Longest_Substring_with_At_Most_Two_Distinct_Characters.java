class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        int max = 0, curMax = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c) && map.size() == 2) {
                char preChar, postChar;
                List<Character> list = new ArrayList<>(map.keySet());
                preChar = map.get(list.get(0)) < map.get(list.get(1)) ? list.get(0) : list.get(1);
                postChar = map.get(list.get(0)) > map.get(list.get(1)) ? list.get(0) : list.get(1);
                curMax = map.get(postChar) - map.get(preChar);

                map.remove(preChar);
            }
            map.put(c, i);
            curMax++;
            max = Math.max(max, curMax);
        }
        
        return max;
    }
}