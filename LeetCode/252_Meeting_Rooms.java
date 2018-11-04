/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

// 扫描线做法 (nlogn)
class Solution {
    private class Point {
        int time;
        int flag;
        
        Point(int time, int flag) {
            this.time = time;
            this.flag = flag;
        }
    }
    
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true;
        }
        
        List<Point> list = new ArrayList<>();
        for (Interval i : intervals) {
            list.add(new Point(i.start, 1));
            list.add(new Point(i.end, 0));
        }
        
        Collections.sort(list, (o1, o2) -> {
            if (o1.time == o2.time) {
                return o1.flag - o2.flag;
            }
            return o1.time - o2.time;
        });
        
        int count = 0;
        for (Point p : list) {
            if (p.flag == 1) {
                count++;
            } else {
                count--;
            }
            
            if (count > 1) {
                return false;
            }
        }
        
        return true;
    }
}