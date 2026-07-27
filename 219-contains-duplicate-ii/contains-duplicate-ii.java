class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            Integer prev = map.get(nums[i]);
            if(prev != null && i - prev <= k) return true;
            map.put(nums[i], i);
        }

        return false;
    }
}