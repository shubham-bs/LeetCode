class Solution {
    public int maxDepth(String s) {
        int count = 0;
        int maxDepth = 0;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(c == '(') count++;
            else if(c == ')') count--;

            maxDepth = Math.max(maxDepth, count);
        }

        return maxDepth;
    }
}