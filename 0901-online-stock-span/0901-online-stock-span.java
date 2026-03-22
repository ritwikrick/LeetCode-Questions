class StockSpanner {

    Stack<int[]> stack;

    StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;

        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.peek()[1];
            stack.pop();
        }

        stack.push(new int[]{price, span});
        return span;
    }

    // NEW METHOD → for array input
    public int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = next(prices[i]); // reuse same logic
        }

        return result;
    }
}