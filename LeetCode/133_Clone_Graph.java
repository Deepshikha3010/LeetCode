/**
 * BFS + HashMap
 * 时间复杂度nm，空间复杂度n
 * 1. 用queue存放已经复制好但复制品node还没添加neighbor的node。
 * 2. Map放对应label的复制品node。
 * 3. 做queue的BFS，每次从queue和map拿到一个原node和对应的复制品node，创建neighbors中还没有复制品的node，将新创建的node放入queue。这样保证queue不会重复。
 * 4. 创建新node的条件是map里面没有对应的label，这个条件与限定放入queue的规则一样。
 * 5. 最后返回map中node对应label的node复制品。
 */

public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null){
            return null;
        }
        // collecting new nodes
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        // collecting old nodes
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        map.put(node.label, new UndirectedGraphNode(node.label));
        while(!queue.isEmpty()){
            UndirectedGraphNode cur = queue.poll();
            UndirectedGraphNode curCopy = map.get(cur.label);
            for(UndirectedGraphNode neighbor : cur.neighbors){
                if(!map.containsKey(neighbor.label)){
                    UndirectedGraphNode newNode = new UndirectedGraphNode(neighbor.label);
                    queue.offer(neighbor);
                    map.put(newNode.label, newNode);
                }
                curCopy.neighbors.add(map.get(neighbor.label));
            }
        }
        return map.get(node.label);
    }
}