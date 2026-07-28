class Solution {
    public int[] scoreValidator(String[] events) {
        int score = 0;
        int counter = 0;

        int i = 0;

        while(i < events.length && counter < 10){
            String event = events[i];
            int currLen = event.length();

            if(currLen == 1){

                if(event.charAt(0) == 'W') counter++;
                else score += event.charAt(0) - '0';

            }else score++;

            i++;
        }

        return new int[] {score, counter};
    }
}