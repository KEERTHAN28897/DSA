class Solution {
    Set<Integer> res = new HashSet<>();
    
    private void rec(int n, int k, int digits, int prev, int num) {
        if(digits == n) {
            res.add(num);
            return;
        }
        
        int n1 = prev + k;
        int n2 = prev - k;
        
        
        if(n1 >= 0 && n1 < 10) {
            int pnum = (int)Math.pow(10, digits)*n1 + num;
            rec(n, k, digits+1, n1, pnum);
        }
        
        if(n2 >= 0 && n2 < 10) {
            int pnum = (int)Math.pow(10, digits)*n2 + num;
            rec(n, k, digits+1, n2, pnum);
        }
        
    }
    
    public int[] numsSameConsecDiff(int n, int k) {
        for(int i = 0; i < 10; ++i) {
            rec(n, k, 1, i, i);
        }
        
        List<Integer> ans = new ArrayList<>();
        int min = (int)Math.pow(10, n-1);
        for(int val : res) {
            if(val >= min) {
                ans.add(val);
            }
        }
        
        int arr[] = new int[ans.size()];
        int i = 0;
        for(int val : ans) {
            arr[i] = val;
            i++;
        }
        
        
        return arr;
    }
}