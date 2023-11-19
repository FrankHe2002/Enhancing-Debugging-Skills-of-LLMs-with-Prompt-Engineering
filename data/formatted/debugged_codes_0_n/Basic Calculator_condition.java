class Solution {
    int idx;

    public int calculate(String s) {
        idx = 0;
        return helper(s);
    }

    private int helper(String s) {
        int res = 0, num = 0, preSign = 1, n = s.length();
        while (idx < n) {
            char c = s.charAt(idx++);
            if (c == '(') num = helper(s);
            else if (c >= '0' && c <= '9') num = num * 10 + c - '0';
            if (c == '+' || c == '-' || c == ')' || idx == n) {
                res += preSign * num;
                if (c == ')') return res;
                num = 0;
                preSign = c == '+' ? 1 : - 1;
            }
        }
        return res;
    }
}