class LRUCache {
    private class ListNode {
        int val;
        int key;
        ListNode pre;
        ListNode next;
        
        ListNode(int val, int key) {
            this.val = val;
            this.key = key;
        }
    }
    
    int capacity;
    int size;
    ListNode head, tail;
    Map<Integer, ListNode> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new ListNode(0, 0);
        this.tail = new ListNode(0, 0);
        head.next = tail;
        tail.pre = head;
        this.map = new HashMap<>();
        this.size = 0;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        
        ListNode cur = map.get(key);
        extract(cur);
        insertFront(cur);
        
        return cur.val;
    }
    
    public void put(int key, int value) {
        if(get(key) != -1) {
            ListNode cur = map.get(key);
            cur.val = value;
            return;
        }
        ListNode cur = new ListNode(value, key);
        map.put(key, cur);

        insertFront(cur);
        size++;
        if(size > capacity) {
            map.remove(tail.pre.key);
            extract(tail.pre);
            size--;
        }
    }
    
    private void insertBack(ListNode node) {
        node.pre = tail.pre;
        node.next = tail;
        node.pre.next = node;
        tail.pre = node;
    }
    
    private void insertFront(ListNode node) {
        node.pre = head;
        node.next = head.next;
        head.next = node;
        node.next.pre = node;
    }
    
    private void extract(ListNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.pre = null;
        node.next = null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */