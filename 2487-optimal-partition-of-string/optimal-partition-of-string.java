class Solution {
    public int partitionString(String s) {
        boolean[] seen = new boolean[26];
        int ans = 0;

        int r = 0;

        while(r < s.length()){
            int idx = s.charAt(r) -'a';

            if(seen[idx]){
                ans++;
                seen = new boolean[26];
            }

            seen[idx] = true;
            r++;
        }

        return ans +1;
    }
}