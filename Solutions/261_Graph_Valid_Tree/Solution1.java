/**
 * Type: Union Find
 * Time: E + V
 * Space: V
 */
class Solution {
    class UnionFind {
        int[] father;

        UnionFind(int n) {
            father = new int[n];
            for (int i = 0; i < n; i++) {
                father[i] = i;
            }
        }

        int find(int a) {
            if (father[a] == a) {
                return a;
            }
            return father[a] = find(father[a]);
        }

        void connect(int a, int b) {
            int root_a = find(a);
            int root_b = find(b);

            if (root_a != root_b) {
                father[root_a] = root_b;
            }
        }
    }
    
    public boolean validTree(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            
            if (uf.find(from) == uf.find(to)) {
                return false;
            }
            uf.connect(from, to);
        }
        
        int root = uf.find(0);
        for (int i = 1; i < n; i++) {
            if (uf.find(i) != root) {
                return false;
            }
        }
        
        return true;
    }
}