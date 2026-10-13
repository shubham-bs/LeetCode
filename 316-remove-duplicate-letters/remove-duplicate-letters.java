class Solution {
    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26];
        boolean[] used = new boolean[26];

        for(char c: s.toCharArray()) freq[c -'a']++;

        StringBuilder sb = new StringBuilder();

        for(char c: s.toCharArray()){
            int idx = c -'a';
            freq[idx]--;

            if(used[idx]) continue;

            while(
                sb.length() != 0 &&
                sb.charAt(sb.length() -1) > c &&
                freq[sb.charAt(sb.length() -1) -'a'] > 0
            ){
                used[sb.charAt(sb.length() -1) -'a'] = false;
                sb.deleteCharAt(sb.length() -1);
            }

            sb.append(c);
            used[idx] = true;
        }

        return sb.toString();
    }
}