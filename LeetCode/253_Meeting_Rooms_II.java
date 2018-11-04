/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        
        Queue<Interval> pqStart = new PriorityQueue<>((o1, o2) -> {
            return o1.start - o2.start;
        });
        
        for (Interval in : intervals) {
            pqStart.offer(in);
        }
        
        
        Queue<Interval> pqEnd = new PriorityQueue<>((o1, o2) -> {
            return o1.end - o2.end;
        });
        
        pqEnd.offer(pqStart.poll());
        int min = 1;
        while (!pqStart.isEmpty()) {
            Interval cur = pqStart.poll();
            Interval pre = pqEnd.peek();
            if (cur.start < pre.end) {
                pqEnd.offer(cur);
                min++;
            } else {
                pqEnd.poll();
                pqEnd.offer(cur);
            }
        }
        
        return min;
    }
}

// 扫描线方法 (nlogn)
class Solution {
    private class Point {
        int time;
        int flag;
        
        Point(int time, int flag) {
            this.time = time;
            this.flag = flag;
        }
    }
    
    public int minMeetingRooms(Interval[] intervals) {
        List<Point> list = new ArrayList<>();
        for (Interval in : intervals) {
            list.add(new Point(in.start, 1));
            list.add(new Point(in.end, 0));
        }
        
        Collections.sort(list, (o1, o2) -> {
            if (o1.time == o2.time) {
                return o1.flag - o2.flag;
            }
            return o1.time - o2.time;
        });
        
        int count = 0, res = 0;
        for (Point p : list) {
            if (p.flag == 1) {
                count++;
            } else {
                count--;
            }
            res = Math.max(count, res);
        }
        
        return res;
    }
}