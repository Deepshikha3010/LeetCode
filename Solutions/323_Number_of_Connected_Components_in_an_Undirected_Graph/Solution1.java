/**
 * Type: DFS
 * Time: E*V
 * Space: E*V + V
 */
class Solution {
    public int countComponents(int n, int[][] edges) {
        if (n <= 1) {
            return n;
        }
        List<List<Integer>> lists = new ArrayList<>();
        // V
        for (int i = 0; i < n; i++) {
            lists.add(new ArrayList<>());
        }
        // E
        for (int[] edge : edges) {
            lists.get(edge[0]).add(edge[1]);
            lists.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        int count = 0;
        // E*V
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(visited, i, lists);
            }
        }
        return count;
    }
    
    private void dfs (boolean[] visited, int index, List<List<Integer>> lists) {
        visited[index] = true;
        for (int i : lists.get(index)) {
            if (!visited[i]) {
                dfs(visited, i, lists);
            }
        }
    }
}