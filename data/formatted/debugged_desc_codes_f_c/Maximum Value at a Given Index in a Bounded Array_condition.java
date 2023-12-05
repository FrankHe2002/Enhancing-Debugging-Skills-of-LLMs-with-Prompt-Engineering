```java
class Solution {
    public int maxValue(int n, int index, int maxSum) {
        int low = 1, mid = 0, high = 1000000000;
        while (low <= high) {
            mid = (low + high) / 2;
            if (calcAns(mid, index, n) < maxSum) {
                high = mid - 1;
            } else if (calcAns(mid + 1, index, n) <= maxSum) {
                low = mid + 1;
            } else {
                break;
            }
        }
        return mid;
    }

    public int calcAns(int max, int idx, int n) {
        long ret = calcPart(max - 1, idx) + calcPart(max, n - idx);
        if (ret > 1000000000) {
            return 1000000001;
        } else {
            return (int) ret;
        }
    }

    public long calcPart(int a, int num) {
        long an = 0, extraOnes = 0;
        long ans = 0;
        if (num >= a) {
            an = 1;
            extraOnes = num - a;
        } else if (num < a) {
            extraOnes = 0;
            an = a - num + 1;
        }
        ans = ((an + a) * (a - an + 1)) / 2;
        ans += extraOnes;
        return ans;
    }
}
```