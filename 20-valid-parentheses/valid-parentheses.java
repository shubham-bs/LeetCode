class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char c: s.toCharArray()){
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }
            if(c == ')'){
                if(stack.isEmpty() || stack.pop() != '('){
                    return false;
                }
            }
            if(c == ']'){
                if(stack.isEmpty() || stack.pop() != '['){
                    return false;
                }
            }
            if(c == '}'){
                if(stack.isEmpty() || stack.pop() != '{'){
                    return false;
                }
            }
        }

        return stack.isEmpty();
        
    }
}