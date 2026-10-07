class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        Set<String> set = new HashSet<>();

        int left = 0, right = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else if (c == ')') {
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }

        dfs(s, 0, left, right, 0, new StringBuilder(), set);

        result.addAll(set);
        return result;
    }

    private void dfs(String s, int index,
                     int leftToRemove, int rightToRemove,
                     int balance,
                     StringBuilder path,
                     Set<String> set) {

        if (balance < 0) return;

        if (index == s.length()) {
            if (leftToRemove == 0 &&
                rightToRemove == 0 &&
                balance == 0) {
                set.add(path.toString());
            }
            return;
        }

        char c = s.charAt(index);

        if (c == '(' && leftToRemove > 0) {
            dfs(s, index + 1, leftToRemove - 1, rightToRemove,
                balance, path, set);
        }

        if (c == ')' && rightToRemove > 0) {
            dfs(s, index + 1, leftToRemove, rightToRemove - 1,
                balance, path, set);
        }

        path.append(c);

        if (c == '(') {
            dfs(s, index + 1, leftToRemove, rightToRemove,
                balance + 1, path, set);
        } else if (c == ')') {
            dfs(s, index + 1, leftToRemove, rightToRemove,
                balance - 1, path, set);
        } else {
            dfs(s, index + 1, leftToRemove, rightToRemove,
                balance, path, set);
        }

        path.deleteCharAt(path.length() - 1);
    }
}