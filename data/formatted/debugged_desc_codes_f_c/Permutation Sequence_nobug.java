Explanation:
The loop condition is incorrect, the loop must run up to n (i less than or equal to n).

Fix:
```java
class Solution {
    public String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            fact = fact * i;
            nums.add(i);
        }
        String res = "";
        k = k - 1; // We use 0 indexing.
        while (true) {
            fact = fact / nums.size();
            res = res + nums.get(k / fact);
            nums.remove(k / fact);
            if (nums.size() == 0) break;
            k = k % fact;
        }
        return res;
    }
}
```