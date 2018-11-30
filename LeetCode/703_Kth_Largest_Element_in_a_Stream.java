class KthLargest {
  PriorityQueue<Integer> pq;
  int k;

  public KthLargest(int k, int[] nums) {
      this.k = k;
      pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
      for (int num : nums) {
          addToQueue(num);
      }
  }
  
  private void addToQueue(int num) {
      pq.offer(num);
      if (pq.size() > k) {
          pq.poll();
      }
  }
  
  public int add(int val) {
      addToQueue(val);
      return pq.peek();
  }
}

/**
* Your KthLargest object will be instantiated and called as such:
* KthLargest obj = new KthLargest(k, nums);
* int param_1 = obj.add(val);
*/