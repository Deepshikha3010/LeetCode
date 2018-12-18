/**
 * Type: Union Find
 * Time: n
 * Space: n
 */
class Solution {
    private class UF {
        int[] f;
        
        UF(int n) {
            this.f =  new int[n];
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
    
    
    public int minSwapsCouples(int[] row) {
        if (row == null || row.length == 0) {
            return 0;
        }
        
        int n = row.length;
        int count = 0;
        UF uf = new UF(n);
        
        for (int i = 0; i < n; i += 2) {
            int root_a = uf.find(row[i] / 2);
            int root_b = uf.find(row[i + 1] / 2);
            if (root_a != root_b) {
                uf.connect(root_a, root_b);
                count++;
            }
        }
        
        return count;
    }
}