class Solution {
    
    public void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
    
    public void rec(int[] nums, int l, int r, Set<List<Integer>> ans) {
        if(l >= r) {
              List<Integer> curr = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            curr.add(nums[i]);
        }
        ans.add(curr);
            return;
        }
    
      
        for(int i = l; i < r; i++) {
            swap(nums, l, i);
            rec(nums, l+1, r, ans);
            swap(nums, i, l);
        }
        return;
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        List<List<Integer>> ans1 = new ArrayList<>();
        rec(nums, 0, nums.length, ans);
        ans1.addAll(ans);
        return ans1;
    }
}