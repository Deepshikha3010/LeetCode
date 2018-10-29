public class Solution {
    /**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int[] S) {
        if (S == null || S.length == 0) {
            return 0;
        }
        
        Arrays.sort(S);
        
        int res = 0;
        for (int i = 0; i < S.length; i++) {
            int target = S[i];
            int start = 0, end = i - 1;
            while (start < end) {
                int cur = S[start] + S[end];
                if (cur > target) {
                    res += end - start;
                    end--;
                } else {
                    start++;
                }
            }
        }
        
        return res;
    }
}