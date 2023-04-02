class Solution {
    public boolean rec(int[] nums, int sum, int i, int[][] dp) {
        //System.out.println(sum);
        if(i == nums.length) {
            return false;
        }
        
        if(sum < 0) {
            return false;
        }
        
        if(dp[sum][i] == -1) {
            return false;
        }
        
        
        if(sum == 0) {
            return true;
        }
        
        if(rec(nums, sum - nums[i], i+1, dp)) {
            return true;
        }
        if(rec(nums, sum, i+1, dp)) {
            return true;
        }
        
        dp[sum][i] = -1;
        return false;
        
    }
    
    
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n : nums) {
            sum += n;
        }
        
        if(sum % 2 != 0) {
            return false;
        }
        
        int[][] dp = new int[sum+1][nums.length+1];
        
        return rec(nums, sum/2, 0, dp);
    }
}