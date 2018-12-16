# [332. Reconstruct Itinerary](https://leetcode.com/problems/reconstruct-itinerary/)

## Type

- Depth-first Search
- Greedy
- Graph

## Explain

Brute force DFS is straightforward. Since we sort lists' order, the first valid answer is the one we should return.

<strong>Hierholzer Algorithm:</strong>

Since this problem is garaunteed to have answer, there should be a `Eulerian path`. It has features as below:

- Any two nodes should be connected by a path
- There will be one and only one node's `indegree` == `outdegree` + 1: end node
- There will be one and only one node's `indegree` == `outdegree` - `: start node
- Every other nodes' `indegree` == `outdegree`

We regard `other nodes` as middlewares, which means we should visit them earlier than `end node`. `Hierholzer Algorithm` is like post-order traversal, so for each node, we traverse its left child nodes (smaller lexical order), then right child nodes, and then itself. Once we visited a node, we delete its `edge` flight from parent node. When there is a `dead node` (no child nodes), we put it into the end of the list. The final result should be reversed order of the list.

## Code

### Solution 1 - Brute Force DFS (Accepted)

```java
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
```

### Solution 2 - Greedy DFS (Hierholzer Algorithm)

```java
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
```