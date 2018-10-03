/**Wish */

//nm
class Solution {
    public String shiftLetters(String s, int[] list) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] sc = s.toCharArray();
        char[] map = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 
                                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        for (int i = 0; i < list.length; i++) {
            int len = list[i];
            for (int j = 0; j < len; j++) {
                char c = sc[j];
                char newC = map[(c - 'a' + 1) % 26];
                sc[j] = newC;
            }
        }
        return new String(sc);
    }
}
