class Solution {
    public int missingMultiple(int[] nums, int k) {
        boolean[] multiples = new boolean[102];

        for(int num: nums){
            if(num % k == 0){
                multiples[num / k] = true;
            }
        } 

        int i = 1;
        while(multiples[i]){
            i++;
        }   

        return i * k;
    }
}