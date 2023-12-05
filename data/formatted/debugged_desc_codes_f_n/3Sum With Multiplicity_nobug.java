```java
class Solution {
    public int threeSumMulti(int[] arr, int target) {
        long[] cnt = new long[101];
        long res = 0;
        for (int i : arr) {
            cnt[i]++;
        }
        for (int i = 0; i < 101 && i <= target; i++) {
            if (cnt[i] == 0) {
                continue;
            }
            for (int j = 0; j < 101 && j <= target; j++) {
                int k = target - i - j;
                if (k < 0 || k >= 101) {
                    continue;
                }
                if (i == j && j == k) {
                    res += cnt[i] * (cnt[i] - 1) * (cnt[i] - 2) / 6;
                } else if (i == j) {
                    res += cnt[i] * (cnt[i] - 1) / 2 * cnt[k];
                } else if (j == k) {
                    res += cnt[j] * (cnt[j] - 1) / 2 * cnt[i];
                } else {
                    res += cnt[i] * cnt[j] * cnt[k];
                }
            }
        }
        return (int) (res % (Math.pow(10, 9) + 7));
    }
}
```