class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        Queue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        return pq.peek();
    }
}