class Solution {
    public int partitionString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = 0;

        int l = 0;
        int r = 0;

        while(r < s.length()){
            int value = map.getOrDefault(s.charAt(r), 0);
            if(value > 0){
                l = r;
                ans++;
                map.clear();
            }
            map.put(s.charAt(r), value +1);
            r++;
        }

        return ans +1;
    }
}