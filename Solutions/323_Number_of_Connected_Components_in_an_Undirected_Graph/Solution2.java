/**
 * Type: Union Find
 * Time: E
 * Space: V
 */
class Solution {
    private int[] parents;
    
    private int find(int n) {
        if (n == parents[n]) {
            return n;
        }
        return parents[n] = find(parents[n]);
    }
    
    public int countComponents(int n, int[][] edges) {
        if (n == 0) return 0;
        
        parents = new int[n];
        for (int i = 0; i < n; i++) parents[i] = i;
        
        // E
        for (int[] edge : edges) {
            int root1 = find(edge[0]);
            int root2 = find(edge[1]);
            if (root1 != root2) {
                parents[root1] = parents[root2];
            }
        }
        
        Set<Integer> set = new HashSet<>();
        for (int i : parents) {
            set.add(find(i));
        }
        
        return set.size();
    }
}