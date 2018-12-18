/**
 * Type: Union Find
 * Ref: https://leetcode.com/problems/redundant-connection-ii/discuss/108045/C%2B%2BJava-Union-Find-with-explanation-O(n)
 * Time: n
 * Space: n
 */
class Solution {
    int[] parents;
    
    private int find(int x) {
        if (x == parents[x]) return x;
        return parents[x] = find(parents[x]);
    }
    
    public int[] findRedundantDirectedConnection(int[][] edges) {
        if (edges == null || edges.length == 0) return new int[0];
        
        int[] cand1 = new int[]{-1, -1};
        int[] cand2 = new int[]{-1, -1};
        
        int n = edges.length;
        parents = new int[n + 1];
        for (int i = 0; i < edges.length; i++) {
            if (parents[edges[i][1]] == 0) {
                parents[edges[i][1]] = edges[i][0];
            } else {
                cand1 = new int[]{parents[edges[i][1]], edges[i][1]};
                cand2 = new int[]{edges[i][0], edges[i][1]};
                edges[i][1] = 0;
            }
        }
        
        for (int i = 1; i <= n; i++) parents[i] = i;
        
        int[] res = new int[]{-1, -1};
        for (int[] edge : edges) {
            if (edge[1] == 0) continue;
            
            int from = edge[0];
            int to = edge[1];
            int root_from = find(edge[0]);
            
            if (root_from == to) {
                res = edge;
            } 
            parents[to] = root_from;
        }
        
        if (res[0] != -1) {
            if (cand1[0] != -1) return cand1;
            return res;
        }
        
        return cand2;
    }
}