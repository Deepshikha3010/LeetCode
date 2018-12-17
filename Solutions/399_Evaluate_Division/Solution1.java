/**
 * Type: DFS
 * Time: n*E
 * Space: V
 */
class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        
        // Time: E; Space: E
        int len = values.length;
        for (int i = 0; i < len; i++) {
            String from = equations[i][0];
            String to = equations[i][1];
            if (!map.containsKey(from)) map.put(from, new HashMap<>());
            if (!map.containsKey(to)) map.put(to, new HashMap<>());
            map.get(from).put(to, values[i]);
            map.get(to).put(from, 1 / values[i]);
        }
        
        double[] res = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String from = queries[i][0];
            String to = queries[i][1];
            Set<String> visited = new HashSet<>();
            // Space: V
            visited.add(from);
            // Time: E
            res[i] = dfs(map, from, to, visited);
        }
        
        return res;
    }
    
    private double dfs(Map<String, Map<String, Double>> map, String from, String to, Set<String> visited) {
        if (!map.containsKey(from)) return -1.0;
        
        if (from.equals(to)) return 1.0;
        
        if (map.get(from).containsKey(to)) return map.get(from).get(to);
        
        for (String s : map.get(from).keySet()) {
            if (visited.contains(s)) continue;
            visited.add(s);
            double next = dfs(map, s, to, visited);
            if (next == -1.0) continue;
            return map.get(from).get(s) * next;
        }
        
        return -1.0;
    }
}