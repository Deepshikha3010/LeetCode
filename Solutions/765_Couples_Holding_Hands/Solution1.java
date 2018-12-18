/**
 * Type: Greedy
 * Time: n^2
 * Space: 1
 */
class Solution {
    public int minSwapsCouples(int[] row) {
        if (row == null || row.length == 0) return 0;
        
        int res = 0;
        for (int i = 0; i < row.length; i += 2) {
            if (row[i + 1] == (row[i] ^ 1)) continue;
            
            res++;
            for (int j = i + 1; j < row.length; j++) {
                if (row[j] == (row[i] ^ 1)) {
                    row[j] = row[i + 1];
                    row[i + 1] = row[i] ^ 1;
                    break;
                }
            }
        }
        
        return res;
    }
}