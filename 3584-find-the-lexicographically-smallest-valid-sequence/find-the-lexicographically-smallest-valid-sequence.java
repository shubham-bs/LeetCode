class Solution {
    public int[] validSequence(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();

        int[] suffix = new int[l1 +1];
        suffix[l1] = l2;
        int j = l2 - 1;

        for(int i = l1- 1; i >= 0; i--){

            if(j >= 0 && word1.charAt(i) == word2.charAt(j)){
                j--;
            }

            suffix[i] = j +1;
        }

        int i = 0;
        j = 0;
        boolean seen = false;
        int[] ans = new int[l2];

        while(j < l2 && i < l1){
            if(word1.charAt(i) == word2.charAt(j)){
                ans[j] = i;
                i++;
                j++;
                continue;
            }else if(!seen && suffix[i +1] <= j +1){
                ans[j] = i;
                seen = true;
                i++;
                j++;
                continue;
            }

            i++;
        }

        if(j < l2){
            return new int[] {};
        }

        return ans;
    }
}