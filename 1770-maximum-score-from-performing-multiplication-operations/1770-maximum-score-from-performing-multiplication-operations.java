class Solution {
    public int rec(int[] nums, int[] mul, int op, int left, Integer[][] mem) {
        int n = nums.length;
        if(op >= mul.length) {
            return 0;
        }
        
        if(mem[left][op] != null) {
            return mem[left][op];
        }
        
   
        int right = (nums.length - 1) - (op - left);
        
        int l = rec(nums, mul, op+1, left+1, mem) + nums[left]*mul[op];
        int r = rec(nums, mul, op+1, left, mem) + nums[right]*mul[op];
        int max = Math.max(l, r);
        mem[left][op] = max;
        mem[right][op] = max;
        
        return max;
    }
    
    public int maximumScore(int[] nums, int[] multipliers) {
        Integer[][] mem = new Integer[nums.length][multipliers.length];
        return rec(nums, multipliers, 0, 0, mem);
    }
}