class Solution {
    
    private int rec(String t1, String t2, int i, int j, Integer[][] mem) {
        if(i >= t1.length() || j >= t2.length()) {
            return 0;
        }
        if(mem[i][j] != null) {
            return mem[i][j];
        }
        
        char c1 = t1.charAt(i);
        char c2 = t2.charAt(j);
        
        if(c1 == c2) {
            return rec(t1, t2, i+1, j+1, mem)+1;
        } 
        int n1 = rec(t1, t2, i+1, j, mem);
        int n2 = rec(t1, t2, i, j+1, mem);
        int max = Math.max(n1, n2);
        mem[i][j] = max;
        return max;
        
    }
    public int longestCommonSubsequence(String text1, String text2) {
        Integer[][] mem = new Integer[text1.length()][text2.length()];
        return rec(text1, text2, 0, 0, mem);
    }
}