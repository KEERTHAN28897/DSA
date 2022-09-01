class Solution {
    public int[] dailyTemperatures(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = n-1; i >= 0; i--) {
            if(stack.isEmpty()) {
                stack.add(i);
                ans[i] = 0;
            } else {
                //System.out.println(i + " " + stack);
                int j = stack.peek();
                if(arr[i] < arr[j]) {
                    stack.add(i);
                } else {
                    while(arr[i] >= arr[j]) {
                        stack.pop();
                        if(stack.isEmpty()) {
                            break;
                        }
                        j = stack.peek();
                    }
                    if(stack.isEmpty()) {
                        j = i;
                    }    
                    stack.add(i);
                }
                //System.out.println(j + " " + i);
                ans[i] = j - i;
            }
        }
        return ans;
    }
}