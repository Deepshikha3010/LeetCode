class Solution {
    public boolean judgeCircle(String moves) {
        if (moves == null || moves.length() == 0) {
            return true;
        }
        
        int h = 0;
        int v = 0;
        
        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            if (c == 'U') {
                h++;
            }
            if (c == 'D') {
                h--;
            }
            if (c == 'L') {
                v--;
            }
            if (c == 'R') {
                v++;
            }
        }
        
        return h == 0 && v == 0;
    }
}