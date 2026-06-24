class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        StringBuilder sb = new StringBuilder(n1 +n2);
        int n = Math.min(n1, n2);

        for(int i=0; i<n; i++){
            sb.append(word1.charAt(i)); 
            sb.append(word2.charAt(i));
        }

        if(n == n1){
            sb.append(word2.substring(n));
        }else{
            sb.append(word1.substring(n));
        }
        
        return sb.toString();
    }
}