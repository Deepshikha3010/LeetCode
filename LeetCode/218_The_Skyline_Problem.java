class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        if (buildings == null || buildings.length == 0) {
            return res;
        }
        
        List<int[]> buildingPoints = new ArrayList<>();
        for (int[] b : buildings) {
            buildingPoints.add(new int[]{b[0], -b[2]});
            buildingPoints.add(new int[]{b[1], b[2]});
        }
        
        Collections.sort(buildingPoints, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                } else {
                    return a[1] - b[1];
                }
            }
        });
        
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        queue.offer(0);
        
        // On the left side, get the highest point
        // On the right side, get the second highest point
        int preMax = 0;
        for (int[] bp : buildingPoints) {
            if (bp[1] < 0) {
                queue.offer(-bp[1]);
            } else {
                queue.remove(bp[1]);
            }
            int curHeight = queue.peek();
            if (curHeight != preMax) {
                res.add(new int[]{bp[0], curHeight});
                preMax = curHeight;
            }
        }
        
        return res;
    }
}