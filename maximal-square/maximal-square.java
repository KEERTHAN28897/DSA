class Solution {

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 0;
        for(int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
            if(dp[i][0] == 1) {
                max = 1;
            }
        }
        
        for(int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j] == '1' ? 1 : 0;
            if(dp[0][j] == 1) {
                max = 1;
            }
        }
   
        
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][j] == '0') {
                    dp[i][j] = 0;
                    continue;
                }
                
                int min = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                System.out.println(min);
                if(dp[i-1][j-1] > 0 && dp[i-1][j] > 0 && dp[i][j-1] > 0) {
                    dp[i][j] = min + 1;
                } else {
                    dp[i][j] = min > 1 ? min : 1;
                }
                if(max < dp[i][j]) {
                    max = dp[i][j];
                }
            }
        }
        return max*max;
    }
}