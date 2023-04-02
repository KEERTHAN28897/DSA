class Solution {
    
    public int[] getColors(int color) {
        if(color == 1) {
            return new int[]{0, 2};
        }
        
        if(color == 2) {
            return new int[]{0, 1};
        }
    
        if(color == 0) {
            return new int[]{1, 2};
        }
        return new int[]{0, 0};
    }
    
    public int rec(int[][] costs, int i, int color, int[][] dp) {
        if(i == costs.length) {
            return 0;
        }
        if(dp[i][color] != 0) {
            return dp[i][color];
        }
        
        int[] colors = getColors(color);
        int value = Math.min(rec(costs, i+1, colors[0], dp) + costs[i][colors[0]], 
                rec(costs, i+1, colors[1], dp) + costs[i][colors[1]]);
        dp[i][color] = value;
        return value;
    }
    
    public int minCost(int[][] costs) {
        int dp[][] = new int[costs.length+1][3];
        int red = rec(costs, 1, 0, dp) + costs[0][0];
        int blue = rec(costs, 1, 1, dp) + costs[0][1];
        int green = rec(costs, 1, 2, dp) + costs[0][2];
        return Math.min(red, Math.min(blue, green));
    }
}