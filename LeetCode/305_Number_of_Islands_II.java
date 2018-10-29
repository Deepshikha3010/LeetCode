// o(n): n is the length of positions
class Solution {
    private int converttoId(int y, int x, int n) {
        return y * n + x;
    }
    
    private class UF {
        int[] f;
        
        UF(int m, int n) {
            this.f = new int[n * m];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int id = converttoId(i, j, n);
                    f[id] = id;
                }
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
    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if (positions == null || positions.length == 0) {
            return res;
        }
        
        int[] dy = new int[]{1, 0, -1, 0};
        int[] dx = new int[]{0, 1, 0, -1};
        int[][] island = new int[m][n];
        
        UF uf = new UF(m, n);
        int count = 0;
        
        for (int i = 0; i < positions.length; i++) {
            int y = positions[i][0];
            int x = positions[i][1];
            
            if (island[y][x] != 1) {
                count++;
                island[y][x] = 1;
                int id = converttoId(y, x, n);
                for (int j = 0; j < 4; j++) {
                    int ny = y + dy[j];
                    int nx = x + dx[j];
                    if (inBound(island, ny, nx) && island[ny][nx] == 1) {
                        int nid = converttoId(ny, nx, n);
                        int fa = uf.find(id);
                        int nfa = uf.find(nid);
                        if (fa != nfa) {
                            count--;
                            uf.connect(id, nid);
                        }
                    }
                }
            }
            res.add(count);
        }
        
        return res;
    }
    
    private boolean inBound(int[][] island, int y, int x) {
        return y >= 0 && y < island.length && x >= 0 && x < island[0].length;
    }
}