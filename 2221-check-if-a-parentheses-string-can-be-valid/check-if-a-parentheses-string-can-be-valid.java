class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length(), minOpen = 0, maxOpen = 0;

        if(n < 2 || n % 2 != 0) return false;

        for(int i = 0; i < n; i++){
            char c = locked.charAt(i);

            if(c == '1'){
                if(s.charAt(i) == '('){
                    minOpen++;
                    maxOpen++;
                }else{
                    minOpen = Math.max(0, minOpen -1);
                    maxOpen--;
                }
            }else{
                minOpen = Math.max(0, minOpen -1);
                maxOpen++;
            }

            if(maxOpen < 0) return false;
        }

        return minOpen == 0;
    }
}