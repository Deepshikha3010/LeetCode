class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0) {
            return nums;
        }
        
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        
        for (int i = 0; i < nums.length; i++) {
            while (deque.size() > 0 && nums[i] >= nums[deque.getLast()]) {
                deque.removeLast();
            }
            
            deque.addLast(i);
            if (i - k + 1 >= 0) {
                res[i - k + 1] = nums[deque.getFirst()];
            }
            if (i - k + 1 >= deque.getFirst()) {
                deque.removeFirst();
            }
        }
        
        return res;
    }
}