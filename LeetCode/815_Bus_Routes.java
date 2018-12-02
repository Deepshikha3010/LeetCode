class Solution {
  public int numBusesToDestination(int[][] routes, int S, int T) {
      if (routes == null || routes.length == 0 || routes[0].length == 0 || S == T) {
          return 0;
      }
      
      Map<Integer, List<Integer>> map = new HashMap<>();
      for (int i = 0; i < routes.length; i++) {
          for (int j : routes[i]) {
              if (!map.containsKey(j)) {
                  map.put(j, new ArrayList<>());
              }
              map.get(j).add(i);
          }
      }
      
      Queue<Integer> queue = new LinkedList<>();
      queue.offer(S);
      int[] visited = new int[routes.length];
      
      int count = 0;
      while (!queue.isEmpty()) {
          int size = queue.size();
          count++;
          for (int i = 0; i < size; i++) {
              int cur = queue.poll();
              for (int bus : map.get(cur)) {
                  if (visited[bus] == 1) {
                      continue;
                  }
                  visited[bus] = 1;
                  for (int stop : routes[bus]) {
                      if (stop == T) {
                          return count;
                      }
                      queue.offer(stop);
                  }
              }
          }
      }
      
      return -1;
  }
}