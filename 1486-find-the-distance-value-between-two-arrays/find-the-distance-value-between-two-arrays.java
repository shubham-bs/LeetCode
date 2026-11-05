class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int ans = 0;

        for(int a: arr1){
            if(isValid(a, arr2, d)) ans++;
        }

        return ans;
    }

    private boolean isValid(int a, int[] arr, int d){
        for(int ar: arr) if(Math.abs(a - ar) <= d) return false;
        return true;
    }
}