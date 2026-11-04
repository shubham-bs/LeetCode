class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(new ArrayList<>() {}, nums, new HashSet<>());

        return ans;
    }

    private void backtrack(
        List<Integer> curr, 
        int[] nums,
        HashSet<Integer> set
    ){
        if(curr.size() == nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }

        //choose
        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])) continue;

            curr.add(nums[i]);
            set.add(nums[i]);

            backtrack(curr, nums, set);

            curr.remove(curr.size() -1);
            set.remove(nums[i]);
        }

    }
}