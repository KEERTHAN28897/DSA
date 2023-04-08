class StockSpanner {
    
    Stack<Integer> stack;
    List<Integer> prices;
    List<Integer> span;
    int count = 0;

    public StockSpanner() {
        stack = new Stack();
        this.prices = new ArrayList<>();
        this.span = new ArrayList<>();
    }
    
    public int next(int price) {
        System.out.println(stack);
        prices.add(price);
        int s = 1;
        if(span.size() == 0) {
            span.add(1);
            stack.add(0);
        } else {
            count++;
            int value = prices.get(stack.peek());
            if(value > price) {
                stack.add(count);
                span.add(1);
            } else {
                while(stack.isEmpty() == false && prices.get(stack.peek()) <= price) {
                    int ans = stack.pop();
                    s = (count - ans) + span.get(ans);
                }
                stack.add(count);
                span.add(s);
            }
        }
        return s;   
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */