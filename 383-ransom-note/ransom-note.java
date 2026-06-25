class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> mag = new HashMap<>();
        HashMap<Character, Integer> ran = new HashMap<>();

        for(char c: magazine.toCharArray()){
            mag.put(c, mag.getOrDefault(c, 0) +1);
        }

        for(char c: ransomNote.toCharArray()){
            if(mag.getOrDefault(c, 0) == 0){
                return false;
            }
            mag.put(c, mag.get(c) -1);
        }
        return true;
        
    }
}