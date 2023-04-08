class Solution {
    int mod = (int)Math.pow(10, 9) + 7;
    public int rec(int target, int[][] types, int i, int j, int[][][] mem) {
        if (i == types.length || j > types[i][0])
            return 0;
        
        if (target == 0) {
             return 1;
        }
           
        
        if(target < 0)
            return 0;
        
        
        
        if(mem[target][i][j] != -1) 
            return mem[target][i][j];
        
        int val = types[i][1];
        
        
        int ans = 0;
   
        ans += rec(target - val, types, i, j+1, mem) % mod;
        ans += rec(target, types, i+1, 0, mem) % mod;

        mem[target][i][j] = ans % mod;
        return ans % mod;
    }
    
    
    
    public int waysToReachTarget(int target, int[][] types) {
        int[][][] mem = new int[target+1][51][51];
        for(int i = 0; i < target+1; i++) {
            for(int j = 0; j < 51; j++) {
                for(int k = 0; k < 51; k++) {
                    mem[i][j][k] = -1;
                }
            }  
        }
        
        return rec(target, types, 0, 0, mem);
    }
}