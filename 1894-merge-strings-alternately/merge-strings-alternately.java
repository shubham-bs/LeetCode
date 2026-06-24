class Solution {
    public String mergeAlternately(String word1, String word2) {
        String ans = "";
        int n = Math.min(word1.length(), word2.length());

        for(int i=0; i<n; i++){
            ans += "" + word1.charAt(i)+ word2.charAt(i);
        }

        if(n == word1.length()){
            ans += "" + word2.substring(n);
        }else{
            ans += "" + word1.substring(n);
        }
        
        return ans;
    }
}