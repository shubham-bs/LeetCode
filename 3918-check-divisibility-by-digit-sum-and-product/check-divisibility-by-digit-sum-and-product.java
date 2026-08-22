class Solution {
    public boolean checkDivisibility(int n) {
       int sum = 0;  
       int prod = 1;
       int m = n;

       while(m > 0){
        sum += m % 10;
        prod *= m % 10;
        m /= 10;
       }

       return n %(sum + prod) == 0;
    }
}