class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(new ArrayList<>() {}, nums, new boolean[nums.length]);

        return ans;
    }

    private void backtrack(
        List<Integer> curr, 
        int[] nums,
        boolean[] bool
    ){
        if(curr.size() == nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }

        //choose
        for(int i = 0; i < nums.length; i++){
            if(bool[i]) continue;

            curr.add(nums[i]);
            bool[i] = true;

            backtrack(curr, nums, bool);

            curr.remove(curr.size() -1);
            bool[i] = false;
        }

    }
}