class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int minSoFar = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++) {

            int profit = prices[i] - minSoFar;
            if(profit > max) {
                max = profit;
            }
            
            if(minSoFar > prices[i]) {
                minSoFar = prices[i];
            }
        }
        return max;
        
    }
}