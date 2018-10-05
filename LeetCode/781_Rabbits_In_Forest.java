class Solution {
    public int numRabbits(int[] answers) {
        if (answers == null || answers.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int min = 0;
        for (int i = 0; i < answers.length; i++) {
            int cur = answers[i];
            if (!map.containsKey(cur)) {
                map.put(cur, 1);
            } else {
                int num = map.get(cur);
                map.put(cur, num + 1);
            }
        }
        
        for (int key : map.keySet()) {
            int num = map.get(key);
            int set = key + 1;
            if (num % set != 0) {
                min += num / set * set + set;
            } else {
                min += num;   
            }
        }
        return min;
    }
}