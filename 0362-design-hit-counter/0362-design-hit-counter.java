class HitCounter {
    
    private Queue<Integer> hits;

    public HitCounter() {
        this.hits = new LinkedList<>();
    }
    
    public void hit(int timestamp) {
        this.hits.add(timestamp);
    }
    
    public int getHits(int timestamp) {
        
        int count = 0;
        while(hits.isEmpty() == false) {
            int t = hits.peek();
            System.out.println(timestamp + " " +  t);
            if((timestamp - t) >= 300) {
                hits.remove();
            } else {
                break;
            }
    
            
        }
        return hits.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */