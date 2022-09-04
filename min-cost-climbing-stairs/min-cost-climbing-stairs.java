class Solution {
    private int rec(int[] cost, int i, int[] mem) {
        if(i >= cost.length) {
            return 0;
        }
        
        if(mem[i] != -1) {
            return mem[i];
        }
        
        int ans = Math.min(rec(cost, i+1, mem), rec(cost, i+2, mem)) + cost[i];
        mem[i] = ans;
        return ans;
    }
    public int minCostClimbingStairs(int[] cost) {
        int[] mem = new int[cost.length];
        Arrays.fill(mem, -1);
        return Math.min(rec(cost, 0, mem), rec(cost, 1, mem));
    }
}