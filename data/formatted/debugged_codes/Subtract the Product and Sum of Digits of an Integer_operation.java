class Solution {
    public int subtractProductAndSum(int n) {
        int mul = 1, sum = 0;
        while (n != 0) {
            int digit = n % 10;
            sum = sum + digit;
            mul = mul * digit;
            n = n / 10;
        }
        return mul - sum;
    }
}