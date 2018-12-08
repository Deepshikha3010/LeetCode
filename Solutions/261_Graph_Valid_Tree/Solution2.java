/**
 * Type: DFS
 * Time: V + E
 * Space: V + E
 */
class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> map = new ArrayList<>();
        // V
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }
        // E
        for (int i = 0; i < edges.length; i++) {
            int v1 = edges[i][0];
            int v2 = edges[i][1];
            map.get(v1).add(v2);
            map.get(v2).add(v1);
        }
        
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        return dfs(map, visited, 0, -1) && visited.size() == n;
    }
    
    // V + E
    private boolean dfs(List<List<Integer>> map, Set<Integer> set, int cur, int pre) {
        List<Integer> list = map.get(cur);
        for (int i = 0; i < list.size(); i++) {
            int n = list.get(i);
            if (n == pre) continue;
            if (set.contains(n)) return false;
            set.add(n);
            if (!dfs(map, set, n, cur)) return false;
        }
        return true;
    }
}