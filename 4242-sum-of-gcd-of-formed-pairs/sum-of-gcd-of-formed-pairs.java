class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int max = 0;
        int[] prefixGcd = new int[n];

        for(int i = 0; i < n; i++){
            max = Math.max(max, nums[i]);
            prefixGcd[i] = gcd(nums[i], max);
        }

        Arrays.sort(prefixGcd);
        int i = 0;
        long sum = 0;

        while(i < n /2){
            sum += gcd(prefixGcd[i], prefixGcd[n - 1 -i]);
            i++;
        }

        return sum;
    }

    private int gcd(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}