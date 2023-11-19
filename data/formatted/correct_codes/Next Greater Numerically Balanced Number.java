class Solution {
    public int nextBeautifulNumber(int n) {

        while (true) {
            n++;
            int num = n;
            int[] freq = new int[10];

            while (num > 0) {
                int rem = num % 10;
                num = num / 10;
                freq[rem] = freq[rem] + 1;
                if (freq[rem] > rem) break;
            }

            boolean ans = true;

            for (int i = 0; i < 10; i++) {
                if (freq[i] != i && freq[i] != 0) {
                    ans = false;
                    break;
                }
            }

            if (ans == true) {
                return n;
            }
        }
    }
}