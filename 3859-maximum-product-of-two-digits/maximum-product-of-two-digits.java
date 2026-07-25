class Solution {
    int largest = -1;
    int secondLargest = -1;

    public int maxProduct(int n) {

        while(n > 0){
            int digit = n % 10;

            if(digit > largest){
                secondLargest = largest;
                largest = digit;
            }else if(digit > secondLargest){
                secondLargest = digit;
            }

            n /= 10;   
        }

        return largest * secondLargest;
    } 
}