class Logger {
    class Record {
        int timestamp;
        String message;
        
        Record(int timestamp, String message) {
            this.timestamp = timestamp;
            this.message = message;
        }
    }
    
    Queue<Record> queue;
    Set<String> set;
    int curTime;

    /** Initialize your data structure here. */
    public Logger() {
        this.queue = new LinkedList<>();
        this.set = new HashSet<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        curTime = timestamp;
        while (!queue.isEmpty() && queue.peek().timestamp <= curTime - 10) {
            Record r = queue.poll();
            set.remove(r.message);
        }
        if (set.contains(message)) {
            return false;
        }
        set.add(message);
        queue.offer(new Record(timestamp, message));
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */