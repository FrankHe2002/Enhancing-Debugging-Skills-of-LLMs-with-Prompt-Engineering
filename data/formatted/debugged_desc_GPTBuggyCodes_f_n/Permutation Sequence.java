```java
class Solution {
    public String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            fact *= i;
            nums.add(i);
        }
        String res = "";
        k--;

        while (true) {
            fact /= n;
            n--;
            res += nums.remove(k / fact);
            if (n == 0) break;
            k %= fact;
        }
        return res;
    }
}
```