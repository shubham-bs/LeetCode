class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int smallCount = 0;
        int equalCount = 0;
        for(int num: nums){
            if(num < target) smallCount++;
            else if(num == target) equalCount++;
        }

        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < equalCount; i++){
            ans.add(smallCount +i);
        }

        return ans;
    }
}