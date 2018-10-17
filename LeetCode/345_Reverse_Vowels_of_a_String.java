class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        
        Set<Character> set = new HashSet<>(Arrays.asList(new Character[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'}));
        char[] sc = s.toCharArray();
        
        int start = 0, end = sc.length - 1;
        while (start < end) {
            while (start < end && !set.contains(sc[start])) {
                start++;
            }
            while (start < end && !set.contains(sc[end])) {
                end--;
            }
            if (start < end) {
                swap(sc, start, end);
                start++;
                end--;
            }
        }
        
        return new String(sc);
    }
    
    private void swap(char[] sc, int start, int end) {
        char temp = sc[start];
        sc[start] = sc[end];
        sc[end] = temp;
    }
}