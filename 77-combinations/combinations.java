class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> curr = new ArrayList<>();

        backtrack(curr, 1, k, n);

        return ans;
    }

    private void backtrack(
        List<Integer> curr,
        int idx,
        int k,
        int n
    ){
        if(curr.size() == k){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i = idx; i <= n; i++){
            curr.add(i);
            //choose
            backtrack(curr, i +1, k, n);

            //unchoose
            curr.remove(curr.size() -1);
        }
    }
}