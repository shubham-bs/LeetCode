class MinStack {

    private static class Pair{
        int num;
        int freq;
        Pair(int num, int freq){
            this.num = num;
            this.freq = freq;
        }
    }

    private final Deque<Integer> stack = new ArrayDeque<>();
    private final Deque<Pair> minStack = new ArrayDeque<>();
    
    public MinStack() {}

    public void push(int value) {
        stack.push(value);
        if(minStack.isEmpty()){
            minStack.push(new Pair(value, 1));
        }else if(value < minStack.peek().num){
            minStack.push(new Pair(value, 1));
        }else if(value == minStack.peek().num){
            minStack.peek().freq++;
        }    
    }
    
    public void pop() {
        int val = stack.pop();
        if(val == minStack.peek().num){
            minStack.peek().freq--;
            if(minStack.peek().freq == 0){
                minStack.pop();
            }
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek().num;
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