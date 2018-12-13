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