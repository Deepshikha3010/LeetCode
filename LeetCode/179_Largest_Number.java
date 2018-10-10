class Solution {
    public String largestNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
        if (nums == null || nums.length == 0) {
            return sb.toString();
        }
        
        int len = nums.length;
        
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return compareString(o2, o1);
            }
        });
        
        for (int num : nums) {
            queue.offer(num);
        }
        
        while(!queue.isEmpty()) {
            int num = queue.poll();
            if (sb.length() >= 1 && sb.charAt(0) == '0' && num == 0) {
                break;
            }
            sb.append(Integer.toString(num));
        }
        
        return sb.toString();
    }
    
    private int compareString(int o1, int o2) {
        String s1 = Integer.toString(o1);
        String s2 = Integer.toString(o2);
        return (s1 + s2).compareTo(s2 + s1);
    }
}