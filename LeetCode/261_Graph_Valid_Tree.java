class Solution {
    private class UF {
        int[] f;
        
        UF(int n) {
            this.f = new int[n];
            for (int i = 0; i < n; i++) {
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
    
    public boolean validTree(int n, int[][] edges) {
        UF uf = new UF(n);
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            int root_a = uf.find(a);
            int root_b = uf.find(b);
            if (root_a == root_b) {
                return false;
            }
            uf.connect(a, b);
        }
        
        int root = uf.find(0);
        for (int i = 1; i < n; i++) {
            if (root != uf.find(i)) {
                return false;
            }
        }
        
        return true;
    }
}