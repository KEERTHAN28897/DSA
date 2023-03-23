class MovingAverage {
    int win;
    int currIndex = 0;
    List<Integer> arr = new ArrayList<>();

    public MovingAverage(int size) {
        win = size;
    }
    
    public double next(int val) {
        if(arr.size() >= 1) {
            arr.add(arr.get(currIndex-1) + val);
            currIndex++;
        } else {
            currIndex++;
            arr.add(val);
        }
        
        if(arr.size() > win) {
            int n = ((currIndex-1) - win);
            double sum = arr.get(currIndex-1) - arr.get(n);
            return sum / win;
        } else {
            return  (double)arr.get(currIndex-1) / arr.size();
        }
        
        
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */