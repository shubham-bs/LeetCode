class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        StringBuilder path = new StringBuilder();
        int open = 0, close = 0;
        backtrack(path, open, close, n);
        return ans;
    }

    private void backtrack(
        StringBuilder path,
        int open,
        int close,
        int n
    ){
        if(path.length() == 2 * n){
            ans.add(path.toString());
            return;
        }

        if(open < n){
            path.append('(');
            backtrack(path, open +1, close, n);
            path.deleteCharAt(path.length() -1);
        }

        if(close < open){
            path.append(')');
            backtrack(path, open, close +1, n);
            path.deleteCharAt(path.length() -1);
        }
    }
}