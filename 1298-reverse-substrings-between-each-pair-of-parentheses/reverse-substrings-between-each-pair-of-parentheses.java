class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        int i = 0;

        while(i < n){
            char c = s.charAt(i);

            if(c == ')'){

                StringBuilder temp = new StringBuilder();
                while(stack.peek() != '('){
                    temp.append(stack.pop());
                }

                stack.pop();

                for(int j = 0; j < temp.length(); j++){
                    stack.push(temp.charAt(j));
                }

            }else stack.push(c);

            i++;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}