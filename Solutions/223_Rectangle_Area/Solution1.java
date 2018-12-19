/**
 * Type: Math
 * Reference: http://www.cnblogs.com/grandyang/p/4563153.html
 * Time: 1
 * Space: 1
 */
class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int sum = (C - A) * (D - B) + (G - E) * (H - F);
        
        // No overlapping
        if (E >= C || F >= D || A >= G || B >= H) return sum;
        
        return sum - (Math.min(C, G) - Math.max(A, E)) * (Math.min(D, H) - Math.max(B, F));
    }
}