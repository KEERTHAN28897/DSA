class Solution {
    public int rec(int[] nums, int i, int[] mem) {
        
        if(i == nums.length-1) {
            return 0;
        }
        
        if(i >= nums.length) {
            return 100000;
        }
        
        if(mem[i] != 0) {
            return mem[i];
        }
        
        int val = nums[i];
        int min = 100000;
        while(val > 0) {
            min = Math.min(min, rec(nums, i+val, mem) + 1);
            val--;
        }
        
        mem[i] = min;
        
        return min;
    }
    
    public int jump(int[] nums) {
        int mem[] = new int[nums.length+1];
        return rec(nums, 0, mem);
    }
}