class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);

        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            if (first[idx] == -1) {
                first[idx] = i;
            }
            last[idx] = i;
        }

        List<int[]> validIntervals = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            if (first[i] == -1) continue;

            int left = first[i];
            int right = last[i];
            boolean isValid = true;

            for (int j = left; j <= right; j++) {
                int charIdx = s.charAt(j) - 'a';
                if (first[charIdx] < left) {
                    isValid = false;
                    break;
                }
                right = Math.max(right, last[charIdx]);
            }

            if (isValid) {
                validIntervals.add(new int[]{left, right});
            }
        }

        validIntervals.sort((a, b) -> Integer.compare(a[1], b[1]));

        List<String> ans = new ArrayList<>();
        int prevEnd = -1;

        for (int[] interval : validIntervals) {
            int start = interval[0];
            int end = interval[1];

            if (start > prevEnd) {
                ans.add(s.substring(start, end + 1));
                prevEnd = end;
            } else if (start > validIntervals.get(validIntervals.indexOf(interval) - 1)[0] && end <= prevEnd) {
                ans.set(ans.size() - 1, s.substring(start, end + 1));
                prevEnd = end;
            }
        }

        return ans;
    }
}
