class Solution {
    public int uniqueXorTriplets(int[] nums) {

        int n = nums.length;

        HashSet<Integer> pairXor = new HashSet<>();

        // All possible XORs of two elements
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                pairXor.add(nums[i] ^ nums[j]);
            }
        }

        HashSet<Integer> ans = new HashSet<>();

        // XOR each pair XOR with every number
        for (int x : pairXor) {
            for (int num : nums) {
                ans.add(x ^ num);
            }
        }

        return ans.size();
    }
}