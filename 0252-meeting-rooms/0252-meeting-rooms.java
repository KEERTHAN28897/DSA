class Interval implements Comparable<Interval> {
    int start;
    int end;
    
    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Interval other) {
        return Integer.compare(this.start,  other.start);
    }
    
}

class Solution {
    
    
    public boolean canAttendMeetings(int[][] intervals) {
        int n = intervals.length;
        PriorityQueue<Interval> pq = new PriorityQueue<>();
        for(int i = 0; i < n; i++) {
            pq.add(new Interval(intervals[i][0], intervals[i][1]));
        }
        
        int last = -1;
        while(pq.isEmpty() == false) {
            Interval interval = pq.remove();
            if(last > interval.start) {
                return false;
            }
    
            last = interval.end;
        }
        return true;       
    }
}