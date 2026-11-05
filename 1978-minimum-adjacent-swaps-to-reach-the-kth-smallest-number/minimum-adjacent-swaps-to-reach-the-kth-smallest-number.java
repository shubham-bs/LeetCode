class Solution {
    public int getMinSwaps(String num, int k) {
        String org = new String(num);

        while(k-- > 0) num = nextPermutation(num);

        char[] arr = num.toCharArray();
        int ans = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == org.charAt(i)) continue;

            int j = i +1;
            while(j < arr.length && arr[j] != org.charAt(i)) j++;

            while(j > i){
                char temp = arr[j];
                arr[j] = arr[j -1];
                arr[j -1] = temp;
                ans++;
                j--;
            }
        }

        return ans;

        
    }

    private String nextPermutation(String num){
        int n = num.length();
        int pivot = -1;
        StringBuilder sb = new StringBuilder(num);

        for(int i = n -2; i >= 0; i--){
            if(sb.charAt(i) < sb.charAt(i +1)){
                pivot = i;
                break;
            }
        }

        if(pivot == -1){
            reverse(sb, 0, n -1);
            return sb.toString();
        }

        int i = n -1;
        while(i >= 0){
            if(sb.charAt(i) > sb.charAt(pivot)){
                swap(sb, pivot, i);
                break;
            }
            i--;
        }

        reverse(sb, pivot +1, n -1);

        return sb.toString();
    }

    private void swap(StringBuilder sb, int i, int j){
        char temp = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));;
        sb.setCharAt(j, temp);
    }

    private void reverse(StringBuilder sb, int i, int j){
        while(i <= j){
            swap(sb, i, j);
            i++;
            j--;
        }
    }
}