class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hash = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(hash.containsKey(target - nums[i])) {
                int[] ans = {hash.get(target - nums[i]), i};
                return ans;
            } else {
                hash.put(nums[i], i);
            }
        }
        return null;
    }
}