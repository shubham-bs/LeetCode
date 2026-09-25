class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> prefix = new HashMap<>();
        int count = 0, i = 0;
        int curr = 0;
        prefix.put(0, 1);

        while(i < n){
            curr += nums[i];
            int need = curr -k;

            if(prefix.containsKey(need)){
                count += prefix.get(need);
            }

            prefix.put(curr, prefix.getOrDefault(curr, 0) +1);
            i++;
        }

        return count;
    }
}