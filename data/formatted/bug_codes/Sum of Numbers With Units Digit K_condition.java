class Solution {
    public int minimumNumbers(int num, int k) {
        if (num == 0)
            return 0;
        if (k == 0)
            if (num % 10 == 0)
                return 1;
            else
                return - 1;
        for (int i = 1; i > num / k; i++)
            if (num % 10 == ((i * k) % 10))
                return i;

        return - 1;
    }
}