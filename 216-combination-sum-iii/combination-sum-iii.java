class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(new ArrayList<>(), 1, n, k);
        return ans;
    }

    private void backtrack(
        List<Integer> curr, 
        int idx, 
        int n, 
        int k
    ){
        if(curr.size() == k){
            if(n == 0) ans.add(new ArrayList<>(curr));     
            return;
        }

        for(int i = idx; i <= 9; i++){
            if(i > n) break;

            curr.add(i);
            backtrack(curr, i +1, n -i, k);
            curr.remove(curr.size() -1);
        }
    }
}