class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
    
        int arr[] = new int[length];
        for(int i = 0; i < updates.length; i++) {
            arr[updates[i][0]] += updates[i][2];
            int end = updates[i][1];
            if(end < (length-1)) {
                arr[end+1] -= updates[i][2];
            }   
        }
        
        for(int i = 1; i < length; i++) {
            arr[i] = arr[i] + arr[i-1];
        }
        return arr;
    }
}