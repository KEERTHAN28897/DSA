class Solution {
    int max = 0;
    public int rec(int[] nums, int i, int[] mem, boolean[] bmem) {
        if(i >= nums.length) {
            return 0;
        }
        if(bmem[i]) {
            return mem[i];
        }
        //System.out.println(i);
        int val = Math.max(rec(nums, i+1, mem, bmem), rec(nums, i+2, mem, bmem) + nums[i]);
        //System.out.println(i + " " + val);
        bmem[i] = true;
        mem[i] = val;
        return val;
    }
    
    public int rob(int[] nums) {
        int[] mem = new int[nums.length];
        boolean[] bmem = new boolean[nums.length];
        
        return rec(nums, 0, mem, bmem);
    }
}