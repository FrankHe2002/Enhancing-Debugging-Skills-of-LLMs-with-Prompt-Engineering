The bug in the code is due to a logical error. The for loop should be running until the condition `i <= n` to fill the `nums` list with numbers from 1 to `n` inclusive, and the `fact` variable should be initialized to `n!` which could be calculated using the factorial equation.

Fix:
```java
class Solution {
    public String getPermutation(int n, int k) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        String res = "";
        k = k - 1;
        while (true) {
            fact = fact / nums.size();
            res = res + nums.remove(k / fact);
            if (nums.size() == 0) break;
            k = k % fact;
        }
        return res;
    }
}
```