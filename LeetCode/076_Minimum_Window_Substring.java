// o(256n)
class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t.length() > s.length()) {
            return "";
        }
        
        int[] sourceMap = new int[256];
        int[] targetMap = new int[256];
        
        initMap(targetMap, t);
        
        String res = "";
        int count = Integer.MAX_VALUE;
        int i = 0, j = 0;
        for (i = 0; i < s.length(); i++) {
            while (!valid(sourceMap, targetMap) && j < s.length()) {
                sourceMap[s.charAt(j)]++;
                j++;
            }
            if (valid(sourceMap, targetMap)) {
                if (count > j - i) {
                    count = j - i;
                    res = s.substring(i, j);
                }
            }
            sourceMap[s.charAt(i)]--;
        }
        
        return res;
    }
    
    private boolean valid(int[] sourceMap, int[] targetMap) {
        for (int i = 0; i < 256; i++) {
            if (targetMap[i] > sourceMap[i]) {
                return false;
            }
        }
        return true;
    }
    
    private void initMap(int[] targetMap, String t) {
        for (char c : t.toCharArray()) {
            targetMap[c]++;
        }
    }
}

//o(n)
class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t.length() > s.length()) {
            return "";
        }
        
        int[] sourceMap = new int[256];
        int[] targetMap = new int[256];
        
        int numT = initMap(targetMap, t);
        
        String res = "";
        int numS = 0;
        int count = Integer.MAX_VALUE;
        
        for (int i = 0, j = 0; j < s.length(); j++) {
            char cur = s.charAt(j);
            sourceMap[cur]++;
            if (sourceMap[cur] == targetMap[cur]) {
                numS++;
            }
            
            while (numS >= numT) {
                if (count > j - i + 1) {
                    count = j - i + 1;
                    res = s.substring(i, j + 1);
                }
                if (sourceMap[s.charAt(i)] == targetMap[s.charAt(i)]) {
                    numS--;
                }
                sourceMap[s.charAt(i)]--;
                i++;
            }
        }
        
        return res;
    }
    
    private int initMap(int[] targetMap, String t) {
        int numT = 0;
        for (char c : t.toCharArray()) {
            targetMap[c]++;
            if (targetMap[c] == 1) {
                numT++;
            }
        }
        return numT;
    }
}