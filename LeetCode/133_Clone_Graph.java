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
        // Collect projection (old node => new node).
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        // Collect old node that its projection (new node) has not got neighbors.
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        map.put(node.label, new UndirectedGraphNode(node.label));
        while(!queue.isEmpty()){
            // 但凡刚从queue出来的node，本次循环会使其复制品和neighbors完备。
            UndirectedGraphNode cur = queue.poll();
            UndirectedGraphNode curCopy = map.get(cur.label);
            for(UndirectedGraphNode neighbor : cur.neighbors){
                // If new neighbor node doesn't exist, create a new one, and put it into queue (since it should not have beighbors right now). 之前遇到过的node肯定已经有了复制品，没有复制品的之前肯定没遇到过。没遇到过也肯定没neighbors，所以放入queue。
                if(!map.containsKey(neighbor.label)){
                    UndirectedGraphNode newNode = new UndirectedGraphNode(neighbor.label);
                    // 就是把所有node复制一遍，用的map的意义就是不重复复制node。
                    queue.offer(neighbor);
                    map.put(newNode.label, newNode);
                }
                // Add new neighbor node to new node's neighbors. 负责将neighbor复制品放入node复制品的neighbors里面。
                curCopy.neighbors.add(map.get(neighbor.label));
            }
        }
        return map.get(node.label);
    }
}