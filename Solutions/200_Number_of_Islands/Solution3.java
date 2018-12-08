/**
 * Type: Union Find
 * Time: n
 * Space: n
 */
class Solution {
    private class UnionFind {
        int[] father;
        int m, n;
        int count;
        
        UnionFind(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            father = new int[m * n];
            count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        count++;
                    }
                    father[i * n + j] = i * n + j;
                }
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
            if(root_a != root_b) {
                father[root_a] = root_b;
                count--;
            }
        }
    }
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        
        UnionFind uf = new UnionFind(grid);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    if (i > 0 && grid[i - 1][j] == '1') {
                        uf.connect(i * n + j, (i - 1) * n + j);
                    }
                    if (i < m - 1 && grid[i + 1][j] == '1') {
                        uf.connect(i * n + j, (i + 1) * n + j );
                    }
                    if (j > 0 && grid[i][j - 1] == '1') {
                        uf.connect(i * n + j, i * n + j - 1);
                    }
                    if (j < n - 1 && grid[i][j + 1] == '1') {
                        uf.connect(i * n + j, i * n + j + 1);
                    }
                }
            }
        }
        
        return uf.count;
    }
}