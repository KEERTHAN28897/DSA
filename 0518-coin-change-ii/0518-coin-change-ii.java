class Solution {
    
    public int rec(int amount, int[] coins, int i, int[][] dp) {
        if(i == coins.length) {
            return 0;
        }
        
        if(amount < 0) {
            return 0;
        }
        
        if(amount == 0) {
            return 1;
        }
        
        if(dp[i][amount] != -1) {
            return dp[i][amount];
        }
     
        int n2 = rec(amount, coins, i+1, dp);
        int n1 = rec(amount-coins[i], coins, i, dp);
        
        int ans = n2 + n1;
        
        dp[i][amount] = ans;
        
        return ans;
        
    }
    
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i = 0; i < coins.length+1; i++) {
            for(int j = 0; j < amount+1; j++) {
                dp[i][j] = -1;
            }
        }
        return rec(amount, coins, 0, dp);   
    }
}