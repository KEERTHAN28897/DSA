import java.util.Arrays; 
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        Arrays.sort(nums1); Arrays.sort(nums2);
        int n1 = nums1.length;
        int n2 = nums2.length;
        List<Integer> res = new ArrayList<>();
        
        int i = 0, j = 0;
        
        while(i < n1 && j < n2) {
            if(nums1[i] == nums2[j]) {
                res.add(nums1[i]);
                i++;
                j++;
            } else if(nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }
        
        int ans[] = res.stream().mapToInt(k->k).toArray();
        
        
        return  ans;
    }
}