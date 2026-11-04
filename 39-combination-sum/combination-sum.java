class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int temp = target;
        backtrack(0, temp, new ArrayList<>() {}, candidates);

        return ans;
    }

    private void backtrack(
        int idx, 
        int temp, 
        List<Integer> curr, 
        int[] candidates
    ){
        if(temp == 0){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(temp < 0 || idx == candidates.length) return;

        curr.add(candidates[idx]);
        backtrack(idx, temp -candidates[idx], curr, candidates);

        curr.remove(curr.size() -1);

        backtrack(idx +1, temp, curr, candidates);
    }
}