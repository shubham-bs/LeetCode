class Solution {
    public int findClosestNumber(int[] nums) {
        int pos = Integer.MAX_VALUE;
        int neg = Integer.MIN_VALUE;

        for(int num :nums){
            if(num < 0){
                neg = Math.max(num, neg);
            }else{
                pos = Math.min(num, pos);
            }
        }

        if(neg == Integer.MIN_VALUE){
            return pos;
        }
        if(pos == Integer.MAX_VALUE){
            return neg;
        }
        if(Math.abs(neg) < pos){
            return neg;
        }
        return pos;
        
    }
}