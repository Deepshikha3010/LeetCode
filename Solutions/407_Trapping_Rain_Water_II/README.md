# [407. Trapping Rain Water II](https://leetcode.com/problems/trapping-rain-water-ii/)

## Type

- Heap
- Breadth-first Search

## Explain

The essense of trapping water problem is to find the lowest boundary around current cell, their diff is the water current cell can take. We imagine there is a global water outside the cells. It is not hard to conclude that `the level of global water can reach (over) a cell is the water level that cell can hold`:

```md
       <------->
        -------
outside |     | inside
        |     |
--------|     |--------
```

It means that it the water follow the natural physical law and reach (over) to a cell, the water level should be the one that cell can hold.

To let the water flow into the maze following the physical law, we can use `Heap (PriorityQueue)` to track the lowest cells starting from the boundary. Previous polled out cells should be always lower than current one. We also use a `max` value to store track the highest cell we reached so far, this `max` value is the water level we want to have: as long as there is a cell lower than current water level, this water level is the level this cell can hold, as we mentioned before. [Visualization](https://www.youtube.com/watch?time_continue=128&v=cJayBq38VYw)

## Code

### Solution 1 - Heap + BFS

```java
/**
 * Type: Heap + BFS
 * Time: m*nlog(m*n)
 * Space: m*n
 */
class Solution {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length < 3 || heightMap[0].length < 3) return 0;
        
        int m = heightMap.length, n = heightMap[0].length;
        int res = 0, max = Integer.MIN_VALUE;

        int[] h = new int[]{0, 1, 0, -1};
        int[] v = new int[]{1, 0, -1, 0};

        boolean[][] visited = new boolean[m][n];
        
        // Put boundary cells into PriorityQueue
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1 , o2) -> o1[2] - o2[2]);
        for (int i = 0; i < m; i++) {
            pq.offer(new int[]{i, 0, heightMap[i][0]});
            pq.offer(new int[]{i, n - 1, heightMap[i][n - 1]});
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }
        for (int i = 1; i < n - 1; i++) {
            pq.offer(new int[]{0, i, heightMap[0][i]});
            pq.offer(new int[]{m - 1, i, heightMap[m - 1][i]});
            visited[0][i] = true;
            visited[m - 1][i] = true;
        }

        // Let water flow in
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            max = Math.max(max, heightMap[cur[0]][cur[1]]);
            for (int k = 0; k < 4; k++) {
                int newY = cur[0] + h[k];
                int newX = cur[1] + v[k];
                if (inBound(heightMap, newY, newX) && !visited[newY][newX]) {
                    pq.offer(new int[]{newY, newX, heightMap[newY][newX]});
                    visited[newY][newX] = true;
                    res += max > heightMap[newY][newX] ? max - heightMap[newY][newX] : 0;
                }
            }
        }

        return res;
    }

    private boolean inBound(int[][] heightMap, int y, int x) {
        return y >= 0 && y < heightMap.length && x >= 0 && x < heightMap[0].length;
    }
}
```