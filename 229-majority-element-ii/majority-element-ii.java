class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        int i = 0;
        while(i < n){
            int count = 0;
            int j = i;
            while(j < n && nums[j] == nums[i]){
                count++;
                j++;
            }
            if(count > n /3) ans.add(nums[i]);
            i = j;
        }

        return ans;
    }
}