class Solution {
    public String largestOddNumber(String num) {
        int r = num.length() -1;
        
        while(r >= 0){
            if((num.charAt(r) - '0') % 2 != 0) return num.substring(0, r +1);
            r--;
        }

        return "";
    }
}