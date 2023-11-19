class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int ans = 10;
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return ans;
        }
        int counter = 9;
        int choiceFiller = 9;
        while (n > 1 && choiceFiller > 0) {
            counter *= choiceFiller--;
            ans += counter;
            n--;
        }
        return ans;
    }
}