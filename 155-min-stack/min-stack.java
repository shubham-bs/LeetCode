class MinStack {

    private static class Pair{
        int value;
        int freq;
        Pair(int value, int freq){
            this.value = value;
            this.freq = freq;
        }
    }

    private final Deque<Integer> stack = new ArrayDeque<>();
    private final Deque<Pair> minStack = new ArrayDeque<>();
    
    public MinStack() {}

    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || val < minStack.peek().value){
            minStack.push(new Pair(val, 1));
        }else if(val == minStack.peek().value){
            minStack.peek().freq++;
        }    
    }
    
    public void pop() {
        int val = stack.pop();
        Pair min = minStack.peek();
        if(val == min.value){
            minStack.peek().freq--;
            if(min.freq == 0){
                minStack.pop();
            }
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek().value;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */