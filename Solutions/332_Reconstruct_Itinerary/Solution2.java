/**
 * Type: Greedy DFS
 * Time: n + nlogn
 * Space: n
 */
class Solution {
    public List<String> findItinerary(String[][] tickets) {
        List<String> res = new ArrayList<>();
        
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        
        for (String[] ticket : tickets) {
            String from = ticket[0];
            String to = ticket[1];
            if (!map.containsKey(from)) map.put(from, new PriorityQueue<>());
            map.get(from).offer(to);
        }
        
        dfs(map, "JFK", res);
        Collections.reverse(res);
        return res;
    }
    
    private void dfs(Map<String, PriorityQueue<String>> map, String start, List<String> res) {
        while (map.containsKey(start) && !map.get(start).isEmpty()) {
            dfs(map, map.get(start).poll(), res);
        }
        
        res.add(start);
    }
}