class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder sb = new StringBuilder();

        if(sum > 9 * num) return sb.toString();

        int digitSum = 0;

        for(int i = 0; i < num; i++){
            sb.append(9);
            digitSum += 9;
        }

        int i = sb.length() -1;

        while(i >= 0){
        
            while(sb.charAt(i) > '0' && digitSum > sum){
                sb.setCharAt(
                    i, 
                    (char) (sb.charAt(i) -1)
                );
                digitSum--;
            }

            i--;
            if(digitSum == sum) break;
        }

        return sb.toString();
    }
}