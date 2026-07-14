class Solution {
    public int findGCD(int[] nums) {
        int min = 1001;
        int max = 0;

        for(int num: nums){
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        return gcd(max, min);

    }

    private int gcd(int a, int b){
        if(b == 0){
            return a;
        }

        return gcd(b, a % b);
    }
}