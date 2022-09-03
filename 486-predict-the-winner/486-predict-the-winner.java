class Solution {
    public int rec(int[] nums, int s, int e, int turn) {
        if(s == e) {
            return turn * nums[s];
        }
        
        int a = turn * nums[s] + rec(nums, s+1, e, -turn);
        int b = turn * nums[e] + rec(nums, s, e-1, -turn);
        return turn * Math.max(turn*a, turn*b);
    }
    public boolean PredictTheWinner(int[] nums) {
        return rec(nums, 0, nums.length-1, 1) >= 0;
    }
}