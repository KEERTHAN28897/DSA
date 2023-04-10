class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> hash = new HashMap<>();
        int count = 0;
        
        if(nums.length > 0) {
            if(nums[0] == k) {
                count++;
            }
            hash.put(nums[0], 1);
        }
        for(int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i-1];
            
            if(nums[i] == k) {
                count++;
            }
            
            
            int diff = nums[i] - k;
            //System.out.println(nums[i] + "  " + k + " " + hash.contains(diff));
            if(hash.containsKey(diff)) {
                count += hash.get(diff);
            }
            

            
            int c = hash.getOrDefault(nums[i], 0);
            hash.put(nums[i], ++c);
        }
        return count;
    }
}