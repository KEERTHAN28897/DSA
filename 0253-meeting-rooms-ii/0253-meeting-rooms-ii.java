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

class Room implements Comparable<Room> {
    int number;
    int last;
    
    Room(int number, int last) {
        this.number = number;
        this.last = last;
    }

    @Override
    public int compareTo(Room other) {
        return Integer.compare(this.last,  other.last);
    }
    
}



class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        PriorityQueue<Interval> pq = new PriorityQueue<>();
        PriorityQueue<Room> room = new PriorityQueue<>();
        for(int i = 0; i < n; i++) {
            pq.add(new Interval(intervals[i][0], intervals[i][1]));
        }
        

        int count = 1;
        room.add(new Room(count, -1));
        while(pq.isEmpty() == false) {
            Interval interval = pq.remove();
            Room available  = room.remove();
            if(interval.start < available.last) {
                count++;
                room.add(new Room(count, interval.end));
                room.add(available);
            } else {
                available.last = interval.end;
                room.add(available);
            }
            
            
        }
        return count;     
    }
}