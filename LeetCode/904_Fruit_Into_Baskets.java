class Solution {
    public int totalFruit(int[] tree) {
        if (tree == null || tree.length == 0) {
            return 0;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0, cur = 0;
        for (int i = 0; i < tree.length; i++) {
            int next = tree[i];
            if (!map.containsKey(next) && map.size() == 2) {
                List<Integer> list = new ArrayList<Integer>(map.keySet());
                int pre1, pre2;
                if (map.get(list.get(0)) < map.get(list.get(1))) {
                    pre1 = list.get(0);
                    pre2 = list.get(1);
                } else {
                    pre1 = list.get(1);
                    pre2 = list.get(0);
                }
                cur = map.get(pre2) - map.get(pre1);
                map.remove(pre1);
            }
            map.put(next, i);
            cur++;
            max = Math.max(max, cur);
        }
        
        return max;
    }
}