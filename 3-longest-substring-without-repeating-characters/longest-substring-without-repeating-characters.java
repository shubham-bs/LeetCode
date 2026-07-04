class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        int max = 0;
        int curr = 0;

        while(r < s.length()){
            if(map.getOrDefault(s.charAt(r), 0) == 0){
                map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) +1);
                curr++;
                r++;
            }else{
                map.put(s.charAt(l), map.getOrDefault(s.charAt(l), 0) -1);
                l++;
                curr--;
            }
            max = Math.max(max, curr);
        }
        return max;
    }
}