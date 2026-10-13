class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> readBinaryWatch(int turnedOn) {
        if(turnedOn > 8) return ans;

        for(int hour = 0; hour <= 11; hour++){
            int hourBits = Integer.bitCount(hour);

            for(int mins = 0; mins <= 59; mins++){
                int minsBit = Integer.bitCount(mins);

                if(hourBits + minsBit == turnedOn){
                    StringBuilder sb = new StringBuilder();

                    sb.append(hour).append(":");

                    if(mins < 10) sb.append(0);

                    sb.append(mins);

                    ans.add(sb.toString());
                }
            }
        }

        return ans;
        
    }
}