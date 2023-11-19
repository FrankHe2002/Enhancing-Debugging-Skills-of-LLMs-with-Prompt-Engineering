class Solution {
    public String longestPrefix(String s) {
        int n = s.length();
        char arr[] = s.toCharArray();
        int lps[] = new int[n];
        for (int i = 1; i < n; i++) {
            int j = lps[i - 1];
            while (j > 0 && arr[j] != arr[i]) {
                j = lps[j - 1];
            }
            if (arr[j] == arr[i]) {
                j++;
            }
            lps[i] = j;
        }
        int j = lps[n - 1];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < j; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();

    }
}
