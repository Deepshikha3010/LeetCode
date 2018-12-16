/**
 * Type: DFS
 * Time: n + nlogn + n!
 * Space: n
 */
class Solution {
    public List<String> findItinerary(String[][] tickets) {
        List<String> res = new ArrayList<>();
        
        int len = tickets.length + 1;
        Map<String, List<String>> map = new HashMap<>();
        
        for (String[] ticket : tickets) {
            String from = ticket[0];
            String to = ticket[1];
            if (!map.containsKey(from)) map.put(from, new ArrayList<>());
            map.get(from).add(to);
        }
        
        for (List<String> list : map.values()) Collections.sort(list);
        
        res.add("JFK");
        dfs(map, "JFK", len, res);
        return res;
    }
    
    private boolean dfs(Map<String, List<String>> map, String start, int len, List<String> res) {
        if (res.size() == len) return true;
        
        if (!map.containsKey(start)) return false;
        
        List<String> dsts = map.get(start);
        for (int i = 0; i < dsts.size(); i++) {
            String dst = dsts.get(i);
            dsts.remove(i);
            res.add(dst);
            if (dfs(map, dst, len, res)) return true;
            dsts.add(i, dst);
            res.remove(res.size() - 1);
        }
        
        return false;
    }
}