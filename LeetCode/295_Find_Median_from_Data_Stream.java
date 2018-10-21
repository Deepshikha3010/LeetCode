class MedianFinder {
    Queue<Integer> left;
    Queue<Integer> right;
    
    /** initialize your data structure here. */
    public MedianFinder() {
        left = new PriorityQueue<>((o1, o2) -> o2 - o1);
        right = new PriorityQueue<>((o1, o2) -> o1 - o2);
    }
    
    public void addNum(int num) {
        if (left.isEmpty() || num < left.peek()) {
            left.offer(num);
        } else {
            right.offer(num);
        }
        
        if (left.size() < right.size()) {
            left.offer(right.poll());
        } else if (left.size() == right.size() + 2) {
            right.offer(left.poll());
        }
        
    }
    
    public double findMedian() {
        if (left.size() > right.size()) {
            return (double)left.peek();
        }
        return (double)(left.peek() + right.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */