class Solution {
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        Map<Integer, Integer> hash = new HashMap<>();
        for(int i = 0; i < nums2.length; i++) {
            if(!hash.containsKey(nums2[i])) {
                hash.put(nums2[i], i);
            }
        }
        
        int[] ans = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++) {
            ans[i] = hash.get(nums1[i]);
        }
        
        return ans;
    }
}