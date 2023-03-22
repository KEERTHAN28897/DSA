class Solution {
    public int[] productExceptSelf(int[] nums) {
        int mul = 1;
        int zeros = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                zeros++;
                continue;
            }
            mul = mul * nums[i];
        }
        
        
        
        for(int j = 0; j < nums.length; j++) {
            if(zeros > 1) {
                nums[j] = 0;
                continue;
            }
            if(nums[j] != 0) {
                if(zeros == 1) {
                   nums[j] = 0; 
                } else {
                   nums[j] = mul / nums[j]; 
                }
                
            } else {
                nums[j] = mul;
            }
            
        }
        return nums;
        
        
    }
}