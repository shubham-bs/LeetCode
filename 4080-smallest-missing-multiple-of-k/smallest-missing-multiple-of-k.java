class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> multiples = new HashSet<>();

        for(int num: nums){
            if(num % k == 0){
                multiples.add(num /k);
            }
        }
        
        int i = 1;
        while(i < multiples.size() +1){
            if(!multiples.contains(i)) break;
            i++;
        }

        return i * k;
    }
}