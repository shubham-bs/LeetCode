class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }

        int org = x;
        int rev = 0;

        while(org != 0){
            int digit = org % 10;
            rev = rev * 10 + digit;
            org /= 10;
        }

        return x == rev;
    }
}