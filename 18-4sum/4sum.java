class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();

        for(int i = 0; i < n; i++){
            long target1 = (long) target - nums[i];

            for(int j = i +1; j < n; j++){
                long target2 = (long) target1 - nums[j];
                HashMap<Long, Integer> map = new HashMap<>();

                for(int k = j +1; k < n; k++){
                    long seen = (long) target2 - nums[k];
                    List<Integer> curr = new ArrayList<>();

                    if(map.containsKey(seen)){
                        curr.add((int) seen);
                        curr.add(nums[k]);
                        curr.add(nums[j]);
                        curr.add(nums[i]);

                        Collections.sort(curr);
                        set.add(curr);
                    }

                    map.put((long) nums[k], k);
                }

                map.clear();
            }
        }

        return new ArrayList<>(set);
    }
}