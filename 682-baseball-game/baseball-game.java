class Solution {
    public int calPoints(String[] operations) {

        Deque<Integer> stack = new ArrayDeque<>();

        for(String op: operations){
            if(op.equals("+")){
                int first = stack.pop();
                int second = stack.peek();
                stack.push(first);
                stack.push(first +second);
            }else if(op.equals("D")){
                stack.push(2 * stack.peek());
            }else if(op.equals("C")){
                stack.pop();
            }else{
                stack.push(Integer.parseInt(op));
            }
        }

        int ans = 0;
        for(int s: stack){
            ans += s;
        }
        return ans;
    }
}