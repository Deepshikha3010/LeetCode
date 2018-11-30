class Solution {
  public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
      List<Integer> res = new ArrayList<>();
      if (pid == null || pid.size() == 0 || ppid == null || ppid.size() == 0) {
          return res;
      }
      
      Map<Integer, List<Integer>> map = new HashMap<>();
      for (int i = 0; i < ppid.size(); i++) {
          if (!map.containsKey(ppid.get(i))) {
              map.put(ppid.get(i), new ArrayList<>());
          }
          map.get(ppid.get(i)).add(pid.get(i));
      }
      
      Queue<Integer> queue = new LinkedList<>();
      queue.offer(kill);
      
      while (!queue.isEmpty()) {
          int cur = queue.poll();
          res.add(cur);
          if (!map.containsKey(cur)) {
              continue;
          }
          for (int child : map.get(cur)) {
              queue.offer(child);
          }
      }
      
      return res;
  }
}