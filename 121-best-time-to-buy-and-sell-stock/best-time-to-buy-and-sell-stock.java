class Solution {
    public int maxProfit(int[] prices) {
        int min = 10001;
        int maxProfit = 0;

        for(int price: prices){
            min = Math.min(min, price);
            int currProfit = 0;

            if(price > min){
                currProfit = price - min;
            }

            maxProfit = Math.max(maxProfit, currProfit);
        }

        return maxProfit;
    }
}