class Solution {
    public int partitionString(String s) {
        int[] map = new int[26];
        int ans = 0;

        int r = 0;

        while(r < s.length()){
            char c = s.charAt(r);
            int value = map[c - 'a'];

            if(value > 0){
                ans++;
                Arrays.fill(map, 0);
            }

            map[c - 'a']++;
            r++;
        }

        return ans +1;
    }
}