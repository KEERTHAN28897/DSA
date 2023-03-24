class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }
        
        int i = k;
        while(i < nums.length) {
            int n  = pq.peek();
            if(nums[i] > n) {
                pq.poll();
                pq.add(nums[i]);
            }
            i++;
        }
        
        return pq.peek();
        
    }
}