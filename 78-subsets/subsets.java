class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> curr = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    public void dfs(int index, int[] nums){
        ans.add(new ArrayList<>(curr));

        for(int i = index; i < nums.length; i++){
            curr.add(nums[i]);
            dfs(i +1, nums);
            curr.remove(curr.size() -1);
        }
    }
}