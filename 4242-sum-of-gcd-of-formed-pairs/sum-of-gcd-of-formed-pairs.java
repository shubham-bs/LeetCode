class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] mx = new int[n];
        int max = 0;
        int[] prefixGcd = new int[n];

        for(int i = 0; i < n; i++){
            max = Math.max(max, nums[i]);
            mx[i] = max;
            prefixGcd[i] = gcd(nums[i], mx[i]);
        }

        Arrays.sort(prefixGcd);
        int i = 0;
        int j = n -1;
        long sum = 0;

        while(i < j){
            sum += gcd(prefixGcd[i], prefixGcd[j]);
            i++;
            j--;
        }

        return sum;
    }

    private int gcd(int a, int b){
        if(b == 0) return a;

        return gcd(b, a % b);
    }
}