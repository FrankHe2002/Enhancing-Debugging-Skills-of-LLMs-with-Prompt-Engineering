```java
class Solution {
public List<Integer> addToArrayForm(int[] num, int k) {
    List<Integer> res = new ArrayList<>();

    int i = num.length;
    while (-- i >= 0 || k > 0) {
        if (i >= 0)
            k += num[i];

        res.add(k % 10);
        k /= 10;
        if (i < 0)
            break;
    }
    Collections.reverse(res);

    return res;
}
}
```