class Solution {
    HashSet<Integer> maxProduct = new HashSet<>();

    public int maxProduct(int n) {
        List<Integer> digits = new ArrayList<>();

        while(n > 0){
            int digit = n % 10;
            n /= 10;
            digits.add(digit);
        }

        digits.sort(null);
        return digits.get(digits.size() -1) * digits.get(digits.size() -2);
    }

   
}