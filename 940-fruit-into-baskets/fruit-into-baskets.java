class Solution {
    public int totalFruit(int[] fruits) {
        int lastFruit = -1, secondLastFruit = -1;
        int lastFruitCount = 0;
        int maxFruits = 0, currWinLen = 0;

        for(int fruit: fruits){
            if(fruit == lastFruit){
                currWinLen++;
                lastFruitCount++;
            }
            else if(fruit == secondLastFruit){
                currWinLen++;
                secondLastFruit = lastFruit;
                lastFruit = fruit;
                lastFruitCount = 1;
            }
            else{
                currWinLen = lastFruitCount +1;
                secondLastFruit = lastFruit;
                lastFruit = fruit;
                lastFruitCount = 1;
            }

            maxFruits = Math.max(maxFruits, currWinLen);
        }

        return maxFruits;
    }
}