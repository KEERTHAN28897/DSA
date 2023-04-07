class Solution {
    
    public int rec(int[] coins, int i, int amount, int[][] mem) {
        if(i == coins.length || amount < 0) {
            return coins.length*11000;
        }
        
        if(amount == 0) {
            return 0;
        }
        
        if(mem[i][amount] != 0) {
            return mem[i][amount];
        }
        
        int n1 = rec(coins, i+1, amount - coins[i], mem) + 1;
        int n2 = rec(coins, i, amount - coins[i], mem) + 1;
        int n3 = rec(coins, i+1, amount, mem);
        
        int ans = Math.min(n3, Math.min(n1, n2));
         
        mem[i][amount] = ans;
        return ans;
        
    }
    
    public int coinChange(int[] coins, int amount) {
        int dp[][] = new int[coins.length+1][amount+1];
        int ans = rec(coins, 0, amount, dp);
        if(ans == coins.length*11000) {
            return -1;
        }
        return ans;
    }
}