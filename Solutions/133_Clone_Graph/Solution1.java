/**
 * Type: DFS
 * Time: n
 * Space: n
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return node;
        
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        
        map.put(node.label, new UndirectedGraphNode(node.label));
        queue.offer(node);
        
        while (!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.poll();
            for (UndirectedGraphNode next : cur.neighbors) {
                if (!map.containsKey(next.label)) {
                    queue.offer(next);
                    map.put(next.label, new UndirectedGraphNode(next.label));
                }
                map.get(cur.label).neighbors.add(map.get(next.label));
            }
        }
        
        return map.get(node.label);
    }
}