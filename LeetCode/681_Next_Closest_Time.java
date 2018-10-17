// time: 4 * 10 | space: 10
class Solution {
    public String nextClosestTime(String time) {
        if (time == null || time.length() == 0) {
            return time;
        }
        
        char[] t = time.toCharArray();
        char[] res = new char[4];
        
        int[] list = new int[10];
        
        char min = '9';
        for (char c : t) {
            if (c == ':') {
                continue;
            }
            list[c - '0'] = 1;
            if (c < min) {
                min = c;
            }
        }
        
        for (int i = t[4] - '0' + 1; i <= 9; i++) {
            if (list[i] > 0) {
                t[4] = (char)(i + '0');
                return new String(t);
            }
        }
        
        t[4] = min;
        for (int i = t[3] - '0' + 1; i <= 5; i++) {
            if (list[i] > 0) {
                t[3] = (char)(i + '0');
                return new String(t);
            }
        }
        
        t[3] = min;
        int stop = t[0] == '2' ? 3 : 9;
        for (int i = t[1] - '0' + 1; i <= stop; i++) {
            if (list[i] > 0) {
                t[1] = (char)(i + '0');
                return new String(t);
            }
        }
        
        t[1] = min;
        for (int i = t[0] - '0' + 1; i <= 2; i++) {
            if (list[i] > 0) {
                t[0] = (char)(i + '0');
                return new String(t);
            }
        }
        
        t[0] = min;
        return new String(t);
    }
}