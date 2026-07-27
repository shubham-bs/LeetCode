class Solution {
    public int thirdMax(int[] nums) {
        Long first = null;
        Long second = null;
        Long third = null;

        for(int num: nums){
            long curr = num;

            if((first != null && num == first) ||
            (second != null && num == second) ||
            (third != null && num == third)){
                    continue;
                }

            if(first == null || curr > first){
                third = second;
                second = first;
                first = curr;
            }else if(second == null || curr > second){
                third = second;
                second = curr;
            }else if(third == null || curr > third){
                third = curr;
            }
        }

        return third == null ? first.intValue(): third.intValue();
    }
}