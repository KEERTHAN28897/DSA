class Solution {
    
    int max = 0;
    
    public int[] getMandN(String[] strs, int j) {
        String str = strs[j];
        int[] ans = new int[2];
        int m = 0; int n = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '0') {
                m++;
            }  else {
                n++;
            }
        }
        ans[0] = m; ans[1] = n;
        return ans;
    }
    
    public int rec(String[] strs, int m, int n, int i, int[][][] mem) {
        //System.out.println("i: " + i + " " + m + " " + n + " " + max + " " + count);
        if(m < 0 || n < 0) {
            return -1;
        } 
        
        
        if(i >= strs.length) {
            return 0;
        }
        
        //System.out.println(m + " " + n + " " + i);
        if(mem[m][n][i] != 0) {
            return mem[m][n][i];
        }
        
        //include
        int[] values = getMandN(strs, i);
        int sum = Math.max( rec(strs, m - values[0], n - values[1], i+1, mem) + 1, 
                           rec(strs, m, n, i+1, mem));
        mem[m][n][i] = sum;
        return sum;
    }
    
    public int findMaxForm(String[] strs, int m, int n) {
        int mem[][][] = new int[m+1][n+1][strs.length+1];
        return rec(strs, m, n, 0, mem);
    }
}