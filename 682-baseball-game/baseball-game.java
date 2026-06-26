class Solution {
    public int calPoints(String[] operations) {

        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;

        for(String op: operations){
            if(op.equals("+")){

                int first = stack.pop();
                int second = stack.peek();
                stack.push(first);
                stack.push(first +second);
                ans += first + second;

            }else if(op.equals("D")){

                int peek = stack.peek();
                stack.push(2 * peek);
                ans += 2 * peek;

            }else if(op.equals("C")){

                int pop = stack.pop();
                ans -= pop;

            }else{
                
                stack.push(Integer.parseInt(op));
                ans += Integer.parseInt(op);
            }
        }

        return ans;
    }
}