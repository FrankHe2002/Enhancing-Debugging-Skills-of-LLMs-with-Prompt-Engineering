```java
class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> res = new ArrayList<>();

        int i = num.length - 1;
        while (i >= 0 || k > 0) {
            if (i >= 0) {
                k += num[i];
            }
            res.add(k % 10);
            k /= 10;
            i -= 1;
        }
        Collections.reverse(res);

        return res;
    }
}
```