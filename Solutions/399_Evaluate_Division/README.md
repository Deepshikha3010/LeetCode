# [399. Evaluate Division](https://leetcode.com/problems/evaluate-division/)

## Type

- Depth-first Search
- Union Find
- Graph

## Explain

<strong>DFS:</strong>

Say we have `a / b = 3.0` and `b / c = 2.0`. We can get the relationship(path) between `a` and `c` like `a / x * ... * y / c`.

As a result, once we build up the graph, we can use `DFS` to try to find such path. When building the graph, we also store equations like `c / b = 0.5`.

<strong>Union Find:</strong>

`a / b = 2.0` and `a / c = 3.0` can be transformed as:

Before `a / c = 3.0`:

```md
index   a   b
root    b   b
dist    2   1
```

After `a / c = 3.0`:

```md
index   a   b    c
root    b   c    c
dist    2   3/2  1
```

From then, once we do `find(a)`, we will have:

```java
String r1 = find(root, dist, equations[i][0]); // a => b
String r2 = find(root, dist, equations[i][1]); // c => c
root.put(r1, r2); // b => c
dist.put(r1, dist.get(equations[i][1]) * values[i] / dist.get(equations[i][0]));  // c * 3 / 2
```

`a / c = 3.0` and `b / c = 2.0` can be transformed as:

```md
index   a   b   c
root    c   c   c
dist    3   2   1
```

When we calculate `a / b`, we should do:

```java
String r1 = find(root, dist, queries[i][0]);
String r2 = find(root, dist, queries[i][1]);
...
res[i] = (double) dist.get(queries[i][0]) / dist.get(queries[i][1]);
```

## Code

### Solution 1 - DFS

```java
/**
 * Type: DFS
 * Time: n*E
 * Space: V + E
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
```

### Solution 2 - Union Find

```java
/**
 * Type: Union Find
 * Ref: https://leetcode.com/problems/evaluate-division/discuss/147281/Java-Union-find-solution-with-detailed-explanation-beat-100
 * Time: E + n
 * Space: E
 */
class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        double[] res = new double[queries.length];

        Map<String, String> root = new HashMap<>();
        Map<String, Double> dist = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String r1 = find(root, dist, equations[i][0]);
            String r2 = find(root, dist, equations[i][1]);
            root.put(r1, r2);
            dist.put(r1, dist.get(equations[i][1]) * values[i] / dist.get(equations[i][0]));
        }

        for (int i = 0; i < queries.length; i++) {
            if (!root.containsKey(queries[i][0]) || !root.containsKey(queries[i][1])) {
                res[i] = -1.0;
                continue;
            }
            String r1 = find(root, dist, queries[i][0]);
            String r2 = find(root, dist, queries[i][1]);
            if (!r1.equals(r2)) {
                res[i] = -1.0;
                continue;
            }
            res[i] = (double) dist.get(queries[i][0]) / dist.get(queries[i][1]);
        }

        return res;
    }

    private String find(Map<String, String> root, Map<String, Double> dist, String s) {
        if (!root.containsKey(s)) {
            root.put(s, s);
            dist.put(s, 1.0);
            return s;
        }

        if (root.get(s).equals(s)) return s;
        String lastP = root.get(s);
        String p = find(root, dist, lastP);
        root.put(s, p);
        dist.put(s, dist.get(s) * dist.get(lastP));
        return p;
    }
}a
```