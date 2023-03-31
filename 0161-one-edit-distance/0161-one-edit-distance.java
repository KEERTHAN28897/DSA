class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int rows = s.length() + 1; int cols = t.length() + 1;
        int[][] arr = new int[s.length() + 1][t.length() + 1];
        
        for(int i = 0; i < cols; i++) {
            arr[0][i] = i;
        }
        
        for(int j = 0; j < rows; j++) {
            arr[j][0] = j;
        }
        
        
        for(int i = 1; i < rows; i++) {
            for(int j = 1; j < cols; j++) {
                if(s.charAt(i-1) == t.charAt(j-1)) {
                    arr[i][j] = arr[i-1][j-1];
                } else {
                    arr[i][j] = Math.min(Math.min(arr[i-1][j], arr[i][j-1]), arr[i-1][j-1]) + 1;
                }
            }
        } 
                
        if(arr[rows-1][cols-1] != 1) {
            return false;
        }
        
        return true;
        
        
    }
}