/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int binarySearch(int l, int r, int target, ArrayReader reader) {
        
        while(l <= r) {
            int mid = l + (r - l) / 2;
            int val = reader.get(mid);
            if (val == target) {
                return mid;
            }
            int left = reader.get(l);
            int right = reader.get(r);
        
            if(right >= target) {
                //within boundray we are
                if(val < target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else {
                l = r;
                r = 2*l;
            }
        }
        return -1;
    }
    
    public int search(ArrayReader reader, int target) {
        int left = 0;
        int right = 1;
        return binarySearch(left, right, target, reader);
    }
}