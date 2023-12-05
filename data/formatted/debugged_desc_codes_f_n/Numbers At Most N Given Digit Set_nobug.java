```java
class Solution {

    // DIGIT DP IS LOVE
    Integer[][][] digitdp;

    public int solve(String num, int pos, boolean bound, Integer[] dig, boolean lead) {

        if (pos == num.length()) {
            return 1;
        }

        int maxDigit = -1;

        if (digitdp[pos][(bound == true) ? 1 : 0][(lead == true) ? 1 : 0] != null)
            return digitdp[pos][(bound == true) ? 1 : 0][(lead == true) ? 1 : 0];

        if (bound) {
            maxDigit = num.charAt(pos) - '0';
        } else {
            maxDigit = 9;
        }

        int ans = 0;
        for (int i = 0; i < dig.length; i++) {

            if (dig[i] < maxDigit) {
                ans += solve(num, pos + 1, false, dig, false);
            } else if (dig[i] == maxDigit) {

                int res = Arrays.binarySearch(dig, maxDigit);

                if (res >= 0) {
                    ans += solve(num, pos + 1, bound & (dig[i] == num.charAt(pos) - '0'), dig, false);
                }

            }
        }

        return digitdp[pos][(bound == true) ? 1 : 0][(lead == true) ? 1 : 0] = ans;

    }

    public int atMostNGivenDigitSet(String[] digits, int n) {

        String num = n + "";
        Integer[] dig = new Integer[digits.length];
        for (int i = 0; i < dig.length; i++) {
            dig[i] = Integer.parseInt(digits[i]);
        }

        digitdp = new Integer[20][2][2];
        return solve(num, 0, true, dig, true) - 1;
    }
}
```