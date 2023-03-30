class Solution {
    public int maxNumberOfApples(int[] weight) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < weight.length; i++) {
            pq.add(weight[i]);
        }
         int totWeight = 5000;
        
        int count = 0;
        while(pq.isEmpty() == false) {
            totWeight = totWeight - pq.poll();
            if(totWeight >= 0) {
                count++;
            } else {
                break;
            }
        }
        
        return count;
        
    }
}