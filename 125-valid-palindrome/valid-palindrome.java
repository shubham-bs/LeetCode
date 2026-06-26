class Solution {
    public boolean isPalindrome(String s) {

        String lower = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int l = 0;
        int r = lower.length() - 1;

        while(l < r){

            if(lower.charAt(l) != lower.charAt(r)){
                return false;
            }
            l++;
            r--;
        }

        return true;
        
    }
}