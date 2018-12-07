/**
 * Type: Two Pointers
 * Time: n
 * Space: 256
 * 
 * Use a count number to track if current substring matches target.
 */

class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        
        int[] map = new int[256];
        int[] goal = new int[256];
        
        int target = initMap(goal, t);
        int slow = 0, fast = 0;
        int count = 0;
        String res = "";
        while (fast < s.length()) {
            char cur = s.charAt(fast);
            if (map[cur] < goal[cur]) {
                count++;
            }
            map[cur]++;
            while (slow <= fast && count >= target) {
                if (res.length() == 0 || res.length() > fast - slow + 1) {
                    res = s.substring(slow, fast + 1);
                }
                char pre = s.charAt(slow);
                map[pre]--;
                if (map[pre] < goal[pre]) {
                    count--;
                }
                slow++;
            }
            fast++;
        }
        return res;
    }
    
    private int initMap(int[] map, String s) {
        int num = 0;
        for (char c : s.toCharArray()) {
            map[c]++;
            num++;
        }
        return num;
    }
}