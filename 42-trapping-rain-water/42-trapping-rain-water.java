class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int lmax[] = new int[n];
        int rmax[] = new int[n];
        
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; ++i) {
            if(stack.isEmpty()) {
                stack.add(height[i]);
                lmax[i] = height[i];
            } else {
                int val = stack.peek();
                if(height[i] < val) {
                    lmax[i] = val;
                    stack.add(height[i]);
                } else {
                    while(height[i] > val) {
                        stack.pop();
                        if(stack.isEmpty()) {
                            val = height[i];
                            break;
                        }
                        val = stack.peek();
                    }
                    lmax[i] = val;
                    stack.add(height[i]);
                }
            }
        }
        
        
        for(int i = n-1; i > 0; --i) {
            if(stack.isEmpty()) {
                stack.add(height[i]);
                rmax[i] = height[i];
            } else {
                int val = stack.peek();
                if(height[i] < val) {
                    rmax[i] = val;
                    stack.add(height[i]);
                } else {
                    while(height[i] > val) {
                        stack.pop();
                        if(stack.isEmpty()) {
                            val = height[i];
                            break;
                        }
                        val = stack.peek();
                    }
                    rmax[i] = val;
                    stack.add(height[i]);
                }
            }
        }
        
        lmax[0] = height[0];
        for(int i = 1; i < n; i++) {
            lmax[i] = Math.max(lmax[i-1], height[i]);
        }
        
        rmax[n-1] = height[n-1];
        
       for(int i = n-2; i > 0; i--) {
            rmax[i] = Math.max(rmax[i+1], height[i]);
        }
        
        
        int trap = 0;
        for(int i = 0; i < n; i++) {
            int x = Math.min(lmax[i], rmax[i]);
            if(x > height[i])
                trap += (x - height[i]);
                
        }
        
        return trap;
        
    }
}