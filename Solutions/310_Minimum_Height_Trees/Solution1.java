/**
 * Type: BFS
 * Time: V^2
 * Space: V
 */
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 0) return res;
        if (n == 1) {
            res.add(0);
            return res;
        }
        
        List<List<Integer>> map = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int v1 = edge[0];
            int v2 = edge[1];
            map.get(v1).add(v2);
            map.get(v2).add(v1);
        }
        
        int min = Integer.MAX_VALUE;
        int[] record = new int[n];
        for (int i = 0; i < n; i++) {
            int count = bfs(i, map);
            min = Math.min(min, count);
            record[i] = count;
        }
        
        for (int i = 0; i < record.length; i++) {
            if (record[i] == min) {
                res.add(i);
            }
        }
        
        return res;
    }
    
    private int bfs(int node, List<List<Integer>> map) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        
        queue.offer(node);
        set.add(node);
        
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                List<Integer> nexts = map.get(cur);
                for (int next : nexts) {
                    if (set.contains(next)) continue;
                    queue.offer(next);
                    set.add(next);
                }
            }
        }
        
        return count;
    }
}