# [133. Clone Graph](https://leetcode.com/problems/clone-graph/)

## Type

- Depth-first Search

## Explain

The aim of clone a graph is to `create` new instance of each node, and then put `neighbor` nodes into neighbor list.

1. Create a `map` mapping `label` to new instance.
2. Use `queue` or `stack` to store the new instances that have not been connected with their neighbors.
3. When get a unknown instance, `create` a new copy of it, and put it into `map`.
4. When poll it from the `queue`, set up it relationship with its neighbors by using `map`.

We use `HashMap` to prevent us from handling exisiting new nodes, so the time complexity is `V + E`.

## Code

### Solution 1 - DFS

```java
/**
 * Type: DFS
 * Time: V + E
 * Space: V
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
```