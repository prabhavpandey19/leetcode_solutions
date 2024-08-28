class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minS;

    public MinStack() {
        stack = new Stack<>();
        minS = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        minS.push(Math.min(!minS.isEmpty()?minS.peek():Integer.MAX_VALUE,val));
    }

    public void pop() {
        stack.pop();
        minS.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minS.peek();
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */