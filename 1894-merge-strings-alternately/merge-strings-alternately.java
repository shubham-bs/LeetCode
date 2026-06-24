class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int n = Math.min(word1.length(), word2.length());

        for(int i=0; i<n; i++){
            sb.append(word1.charAt(i)); 
            sb.append(word2.charAt(i));
        }

        if(n == word1.length()){
            sb.append(word2.substring(n));
        }else{
            sb.append(word1.substring(n));
        }
        
        return sb.toString();
    }
}