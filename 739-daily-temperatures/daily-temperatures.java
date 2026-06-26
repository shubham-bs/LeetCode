class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        Deque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[temperatures.length];

        for(int t =0; t < temperatures.length; t++){
            while(!stack.isEmpty() && temperatures[t] > temperatures[stack.peek()] ){
                ans[stack.peek()] = t - stack.peek();
                stack.pop();
            }
            stack.push(t);
        }

        return ans;
        
    }
}