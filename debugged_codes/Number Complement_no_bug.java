class Solution {
    public int findComplement(int num) {
        int x = 0;
        int sum = 0;
        while (num > 0) {
            int i = num % 2;
            if (i == 0) {
                sum += (int) Math.pow(2, x++);
            } else {
                x++;
            }
            num /= 2;
        }
        return sum;
    }
}