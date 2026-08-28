class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int[] count = new int[26];
        int n = s.length();

        for(int i = 0; i < n; i++){
            count[s.charAt(i) -'a']++;
        }

        int oddCount = 0;
        int oddCharIdx = -1;
        for(int i = 0; i < 26; i++){
            if(count[i] % 2 != 0){
                oddCount++;
                oddCharIdx = i;
            }
            count[i] /= 2; 
        }

        if(oddCount > 1) return "";

        int halfLen = n / 2;
        int matchLen = 0;
        while(matchLen < halfLen){
            int idx = target.charAt(matchLen) - 'a';
            if(count[idx] > 0){
                count[idx]--;
                matchLen++;
            }else break;
        }

        for(int i = matchLen; i >= 0; i--){
            if(i < matchLen){
                count[target.charAt(i) - 'a']++;
            }

            if(i == halfLen){
                StringBuilder sb = new StringBuilder();
                sb.append(target.substring(0, halfLen));
                
                String fullPal = buildCompletePalindrome(sb, count.clone(), oddCharIdx, n);
                if(fullPal.compareTo(target) > 0) return fullPal;
                continue;
            }

            int targetCharIdx = target.charAt(i) - 'a';
            for(int c = targetCharIdx +1; c < 26; c++){
                if(count[c] > 0){
                    StringBuilder sb = new StringBuilder();

                    sb.append(target.substring(0, i));

                    sb.append((char)('a' +c));
                    
                    int[] tempCount = count.clone();
                    tempCount[c]--;

                    String fullPal = buildCompletePalindrome(sb, tempCount, oddCharIdx, n);
                    if(fullPal.compareTo(target) > 0) return fullPal;
                }
            }
        }

        return "";
    }

    private String buildCompletePalindrome(StringBuilder sb, int[] count, int oddCharIdx, int n){
        for(int j = 0; j < 26; j++){
            while(count[j] > 0){
                sb.append((char)('a' +j));
                count[j]--;
            }
        }

        String firstHalf = sb.toString();
        StringBuilder complete = new StringBuilder(firstHalf);

        if(n % 2 != 0){
            complete.append((char)('a' + oddCharIdx));
        }

        for(int j = firstHalf.length() - 1; j >= 0; j--){
            complete.append(firstHalf.charAt(j));
        }

        return complete.toString();
    }
}
