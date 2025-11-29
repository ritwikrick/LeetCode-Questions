class MinStack {

    Stack<Integer> s;
    Stack<Integer> ms;

    public MinStack() {
        s = new Stack<>();
        ms = new Stack<>();
    }
    
    public void push(int val) {
        s.push(val);

        if (ms.isEmpty() || val <= ms.peek()) {
            ms.push(val);
        }
    }
    
    public void pop() {
        int val = s.pop();

        if (val == ms.peek()) {
            ms.pop();
        }
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return ms.peek();
    }
}
