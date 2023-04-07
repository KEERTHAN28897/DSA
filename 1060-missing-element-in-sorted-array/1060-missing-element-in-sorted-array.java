class Solution {
    public int missingElement(int[] nums, int k) { 
        int n = nums.length;
        int start = nums[0];
        int prev = start;
        
        for(int i = 1; i < n; i++) {
            int diff = nums[i] - prev;
            if(diff != 1) {
                while (diff != 1) {
                   k--;
                   prev = prev + 1;
                   if(k == 0) {
                      return prev;
                   }
                   diff = nums[i] - prev;
                }
                prev = prev + 1;
            } else {
                prev = prev + 1;
            }
        }
        
        while( k != 0) {
            nums[n-1]++;
            k--;
        }
        
        return nums[n-1];
        
    }
}