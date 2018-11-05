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
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> res = new ArrayList<>();
        if (schedule == null || schedule.size() == 0) {
            return res;
        }
        
        List<Interval> list = new ArrayList<>();
        for (List<Interval> e : schedule) {
            for (Interval i : e) {
                list.add(i);
            }
        }
        
        Collections.sort(list, (o1, o2) -> {
            if (o1.start == o2.start) {
                return o1.end - o2.end;
            }
            return o1.start - o2.start;
        });
        
        Interval pre = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            Interval cur = list.get(i);
            if (pre.end >= cur.start) {
                pre.end = Math.max(cur.end, pre.end);
            } else {
                res.add(new Interval(pre.end, cur.start));
                pre = cur;
            }
        }
        
        return res;
    }
} 
