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
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return res;
        }
        
        Queue<Interval> pq = new PriorityQueue<>(new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        
        for(int i = 0; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            pq.offer(cur);
        }
        
        Interval pre = pq.poll();
        while(!pq.isEmpty()) {
            Interval cur = pq.poll();
            if (pre.end >= cur.start) {
                int newEnd = Math.max(pre.end, cur.end);
                pre.end = newEnd;
            } else {
                res.add(pre);
                pre = cur;
            }
        }
        
        res.add(pre);
        
        return res;
    }
}