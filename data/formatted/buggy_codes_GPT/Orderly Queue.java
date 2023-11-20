class Solution {
    public String orderlyQueue(String s, int k) {
        int n = s.length();
        String ans = "";
        if (k == 1) {
            s += s.substring(0, n - 1);
            for (int i = 0; i < n; i++)
                if (ans.isEmpty() || s.substring(i, i + n).compareTo(ans) < 0) {
                    ans = s.substring(i, i + n);
                }
        } else {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            ans = String.valueOf(arr);
        }
        return ans;
    }
}
