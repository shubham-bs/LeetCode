class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(0, target, new ArrayList<>() {}, candidates);

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

        for(int i = idx; i < candidates.length; i++){
            if(i > idx && candidates[i] == candidates[i -1]) continue;
            if(candidates[i] > temp) break;

            curr.add(candidates[i]);
            backtrack(i +1, temp -candidates[i], curr, candidates);

            curr.remove(curr.size() -1);
        }

        
    }
}