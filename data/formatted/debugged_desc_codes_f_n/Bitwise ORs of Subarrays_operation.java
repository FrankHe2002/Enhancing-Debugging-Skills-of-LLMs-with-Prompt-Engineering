```java
// Runtime: 454 ms (Top 75.74%) | Memory: 71.3 MB (Top 97.04/)
class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        int n = arr.length;
        Set<Integer> s = new HashSet();
        Set<Integer> cur = new HashSet();
        for (int num : arr) {
            Set<Integer> next = new HashSet();
            next.add(num);
            for (int temp : cur) {
                next.add(temp | num);
            }
            cur = next;
            s.addAll(next);
        }
        return s.size();
    }
}
```