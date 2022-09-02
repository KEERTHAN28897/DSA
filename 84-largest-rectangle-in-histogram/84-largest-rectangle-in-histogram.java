class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.add(-1);
        
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < heights.length; ++i) {
            while(stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                int length = heights[stack.peek()];
                stack.pop();
                int width = i - stack.peek() - 1;
                max = Math.max(max, length*width);
            }
            stack.add(i);
        }
        
        while(stack.peek() != -1 && !stack.isEmpty()) {
            int length = heights[stack.peek()];
            stack.pop();
            int width = heights.length - stack.peek() - 1;
            max = Math.max(max, length*width);
        }
        return max;
    }
}