class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length; int n = matrix[0].length;
        int i = m - 1; int j = 0;
        while(i >= 0 && j < n) {
            
            if(target == matrix[i][j]) {
                return true;
            }
            
            if(target > matrix[i][j] ) {
                j++;
            } else {
                i--;
            }  
        }
    
        for(int k = 0; k < n; k++) {
            if(target == matrix[0][k]) {
                return true;
            }
        }
        
         for(int k = 0; k < m; k++) {
            if(target == matrix[k][n-1]) {
                return true;
            }
        }
        
        
        return false;
        
    }
}