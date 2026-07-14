class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int num: nums){
            set.add(num);
        }

        int longest = 0;

        for(int num: set){
            int len = 0;
            if(!set.contains(num -1)){
                len++;
                int curr = num;

                while(set.contains(curr +1)){
                    curr++;
                    len++;
                }
            }
            longest = Math.max(longest, len);
        }

        return longest;
    }
}