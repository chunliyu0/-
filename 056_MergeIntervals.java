/* Analysis
(1) sort by the start
(2) merge one by one

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals==null)return null;
        List<Interval> ret = new ArrayList<Interval>();
        
        if(intervals.size()==0)return ret;
        
        Comparator<Interval> comparator = new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start; // use your logic
            }
        };
        Collections.sort(intervals, comparator);
        
        Interval pre = intervals.get(0);
        for(Interval interval: intervals){
            if(interval.start <= pre.end){
                pre.end = (interval.end > pre.end ? interval.end: pre.end);
            }
            else{
                ret.add(pre);
                pre = interval;
            }
        }
        ret.add(pre);
        return ret;
    }
}
