class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int min = 0, max = 0;

        for(int weight: weights){
            min = Math.max(min, weight);
            max += weight;
        }
        
        int ans = max;
        while(min <= max){
            int mid = min + (max - min)/ 2;

            int currDays = 1;
            int weightSum = 0;
            
            for(int weight: weights){
                if(weight <= mid - weightSum){
                    weightSum += weight;
                }else{
                    weightSum = weight;
                    currDays++;

                    if(currDays > days) break;
                }
            }

            if(currDays <= days){
                ans = Math.min(ans, mid);
                max = mid -1;
            }else min = mid +1;
        }

        return ans;
    }
}