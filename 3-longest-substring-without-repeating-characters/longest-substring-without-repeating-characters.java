class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        int max = 0;

        while(r < s.length()){
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) +1);
            
            while(map.getOrDefault(s.charAt(r), 0) > 1){
                map.put(s.charAt(l), map.getOrDefault(s.charAt(l), 0) -1);
                l++;
            }
            max = Math.max(max, r -l +1);
            r++;
        }
        return max;
    }
}