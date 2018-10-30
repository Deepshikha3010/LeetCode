class Solution {
    private class UF {
        int[] f;
        
        UF(int n) {
            this.f = new int[n + 1];
            for (int i = 0; i < n + 1; i++) {
                f[i] = i;
            }
        }
        
        int find(int x) {
            if (f[x] == x) {
                return x;
            }
            return f[x] = find(f[x]);
        }
        
        void connect(int a, int b) {
            int root_a = find(a);
            int root_b = find(b);
            if (root_a != root_b) {
                f[root_a] = root_b;
            }
        }
    }
        
    public int[] findRedundantConnection(int[][] edges) {
        if (edges == null || edges.length == 0 || edges[0].length == 0) {
            return new int[0];
        }
        
        UF uf = new UF(edges.length);
        
        int[] res = new int[2];
        for (int i = 0; i < edges.length; i++) {
            int root_a = uf.find(edges[i][0]);
            int root_b = uf.find(edges[i][1]);
            if (root_a == root_b) {
                res[0] = edges[i][0];
                res[1] = edges[i][1];
            }
            uf.connect(edges[i][0], edges[i][1]);
        }
        
        return res;
    }
}