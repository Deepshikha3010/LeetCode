class Solution {
    public int numJewelsInStones(String J, String S) {
        if(J == null || S == null || S.length() == 0) {
            return 0;
        }
        
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < J.length(); i++) {
            char c = J.charAt(i);
            set.add(c);
        }
        
        int res = 0;
        for(int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if(set.contains(c)) {
                res++;
            }
        }
        
        return res;
    }
}