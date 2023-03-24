class Solution {
    public int smallestCommonElement(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        
        Map<Integer, Integer> hash = new HashMap<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int count = hash.getOrDefault(mat[i][j], 0);
                count++;
                hash.put(mat[i][j], count);
                
                //System.out.println(count + " " + n + " " + mat[i][j]);
                if(count == m) {
                    return mat[i][j];
                }
            }
        }
        return -1;
        
        
    }
}