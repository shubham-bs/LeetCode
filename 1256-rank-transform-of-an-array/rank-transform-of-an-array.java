class Solution {
    public int[] arrayRankTransform(int[] arr) {

        int n = arr.length;

        if (n == 0) {
            return arr;
        }

        Integer[] idx = new Integer[n];

        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }

        Arrays.sort(idx, (a, b) -> Integer.compare(arr[a], arr[b]));

        int[] ans = new int[n];

        int rank = 1;
        ans[idx[0]] = rank;

        for (int i = 1; i < n; i++) {

            if (arr[idx[i]] != arr[idx[i - 1]]) {
                rank++;
            }

            ans[idx[i]] = rank;
        }

        return ans;
    }
}