class Solution {
    public boolean checkDivisibility(int n) {
       int sum = 0;  
       int prod = 1;
       int m = n;

       while(m > 0){
        int digit = m % 10;
        m /= 10;
        sum += digit;
        prod *= digit;
       }

       return n %(sum + prod) == 0;
    }
}