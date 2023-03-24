/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/



class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        
        PriorityQueue<Interval> pq = new PriorityQueue<>(new Comparator<Interval>() {
            @Override
            public int compare(Interval f, Interval s) {
                return f.start - s.start;
            }
        });
        
        for(List<Interval> intervals : schedule) {
            for(Interval interval : intervals) {
                pq.add(interval);
            }
        }
        
        int last_min = pq.peek().start;
        int last_max = pq.peek().end;
        List<Interval> res = new ArrayList<>();
;
        
        while(pq.isEmpty() == false) {
            
            Interval interval = pq.poll();
            //System.out.println(interval.start + " " + interval.end);
            if(interval.start > last_max) {
                Interval ans = new Interval(last_max, interval.start);
                res.add(ans);
            }
            if(last_max < interval.end)
                last_max = interval.end;
        }
        
        return res;
    }
}