public class Solution {
    public String smallestNumber(String num, long t) {
        // Step 1: Prime factorise t into 2, 3, 5, 7
        long tempT = t;
        int[] targetFactors = new int[4]; // [count_2, count_3, count_5, count_7]
        int[] primes = {2, 3, 5, 7};
        
        for (int i = 0; i < 4; i++) {
            while (tempT % primes[i] == 0) {
                targetFactors[i]++;
                tempT /= primes[i];
            }
        }
        
        // If t has prime factors outside of {2, 3, 5, 7}, it's impossible
        if (tempT > 1) {
            return "-1";
        }
        
        int n = num.length();
        
        // Prefix factor tracking array
        // prefFactors[i] stores the remaining required factors after processing up to num[i]
        int[][] prefFactors = new int[n][4];
        int[] currFactors = targetFactors.clone();
        
        int firstZeroIdx = -1;
        for (int i = 0; i < n; i++) {
            char ch = num.charAt(i);
            if (ch == '0') {
                firstZeroIdx = i;
                break;
            }
            int val = ch - '0';
            reduceFactors(currFactors, val);
            prefFactors[i] = currFactors.clone();
        }
        
        // Scenario A: The original number matches perfectly and has no zeros
        if (firstZeroIdx == -1 && isSatisfied(currFactors)) {
            return num;
        }
        
        // Scenario B: Find a turning point to increment a digit
        int limit = (firstZeroIdx != -1) ? firstZeroIdx : n - 1;
        
        for (int i = limit; i >= 0; i--) {
            int startDigit = (num.charAt(i) - '0') + 1;
            int[] baseFactors = (i > 0) ? prefFactors[i - 1].clone() : targetFactors.clone();
            
            for (int digit = startDigit; digit <= 9; digit++) {
                int[] nextFactors = baseFactors.clone();
                reduceFactors(nextFactors, digit);
                
                int slotsLeft = n - 1 - i;
                if (minDigitsNeeded(nextFactors) <= slotsLeft) {
                    // Found the smallest modification! Build and return the string.
                    StringBuilder sb = new StringBuilder();
                    sb.append(num, 0, i);
                    sb.append(digit);
                    sb.append(generateSuffix(slotsLeft, nextFactors));
                    return sb.toString();
                }
            }
        }
        
        // Scenario C: Must increase the overall string length
        int totalSlots = n + 1;
        while (true) {
            if (minDigitsNeeded(targetFactors) <= totalSlots) {
                return generateSuffix(totalSlots, targetFactors);
            }
            totalSlots++;
        }
    }
    
    // Reduces the remaining factor counts based on the current digit used
    private void reduceFactors(int[] factors, int digit) {
        if (digit == 2 || digit == 4 || digit == 8 || digit == 6) {
            if (digit == 2) factors[0] = Math.max(0, factors[0] - 1);
            else if (digit == 4) factors[0] = Math.max(0, factors[0] - 2);
            else if (digit == 8) factors[0] = Math.max(0, factors[0] - 3);
            else { // 6
                factors[0] = Math.max(0, factors[0] - 1);
                factors[1] = Math.max(0, factors[1] - 1);
            }
        }
        if (digit == 3 || digit == 9) {
            if (digit == 3) factors[1] = Math.max(0, factors[1] - 1);
            else factors[1] = Math.max(0, factors[1] - 2); // 9
        }
        if (digit == 5) factors[2] = Math.max(0, factors[2] - 1);
        if (digit == 7) factors[3] = Math.max(0, factors[3] - 1);
    }
    
    // Checks if all factor requirements are fully satisfied
    private boolean isSatisfied(int[] factors) {
        return factors[0] == 0 && factors[1] == 0 && factors[2] == 0 && factors[3] == 0;
    }
    
    // Computes the minimum number of digits needed to fulfill the remaining factor states
    private int minDigitsNeeded(int[] factors) {
        int a = factors[0], b = factors[1], c = factors[2], d = factors[3];
        int count = c + d; // 5s and 7s are locked down
        
        count += a / 3;
        int rem2 = a % 3;
        
        count += b / 2;
        int rem3 = b % 2;
        
        if (rem2 == 1 && rem3 == 1) count += 1;      // '6'
        else if (rem2 == 1 && rem3 == 0) count += 1; // '2'
        else if (rem2 == 2 && rem3 == 1) count += 2; // '6' and '2' OR '4' and '3'
        else if (rem2 == 2 && rem3 == 0) count += 1; // '4'
        else if (rem2 == 0 && rem3 == 1) count += 1; // '3'
        
        return count;
    }
    
    // Greedily generates the smallest suffix using '1's at the front
    private String generateSuffix(int slots, int[] factors) {
        int a = factors[0], b = factors[1], c = factors[2], d = factors[3];
        int needed = minDigitsNeeded(factors);
        int ones = slots - needed;
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ones; i++) {
            sb.append('1');
        }
        
        // Collect required digits to sort them in ascending order
        int[] digits = new int[needed];
        int idx = 0;
        
        for (int i = 0; i < c; i++) digits[idx++] = 5;
        for (int i = 0; i < d; i++) digits[idx++] = 7;
        
        while (a >= 3) { digits[idx++] = 8; a -= 3; }
        while (b >= 2) { digits[idx++] = 9; b -= 2; }
        
        if (a == 1 && b == 1) { digits[idx++] = 6; } 
        else if (a == 1 && b == 0) { digits[idx++] = 2; } 
        else if (a == 2 && b == 1) { digits[idx++] = 2; digits[idx++] = 6; } 
        else if (a == 2 && b == 0) { digits[idx++] = 4; } 
        else if (a == 0 && b == 1) { digits[idx++] = 3; }
        
        Arrays.sort(digits);
        for (int digit : digits) {
            sb.append(digit);
        }
        
        return sb.toString();
    }
}
