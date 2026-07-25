class Solution {
    HashSet<Integer> maxProduct = new HashSet<>();

    public int maxProduct(int n) {
        List<Integer> digits = new ArrayList<>();

        while(n > 0){
            int digit = n % 10;
            n /= 10;
            digits.add(digit);
        }

        product(0, digits);
        int max = -1;

        for(int product: maxProduct){
            max = Math.max(max, product);
        }

        return max;
    }

    public void product(int index, List<Integer> digits){

        for(int i = index; i < digits.size(); i++){
            for(int j = i +1; j < digits.size(); j++){
                int prod = digits.get(i) * digits.get(j);
                maxProduct.add(prod);
            }
        }
    }
}