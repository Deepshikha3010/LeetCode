class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        if (A == null || B == null) {
            return null;
        }
        
        int[] res = new int[A.length];
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            int cur = B[i];
            map.put(cur, i);
        }
        
        for (int i = 0; i < res.length; i++) {
            res[i] = map.get(A[i]);
        }
        
        return res;
    }
}