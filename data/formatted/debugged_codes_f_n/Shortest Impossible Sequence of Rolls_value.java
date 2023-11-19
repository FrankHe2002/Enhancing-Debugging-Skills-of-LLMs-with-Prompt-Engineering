```java
class Solution {
    public int shortestSequence(int[] rolls, int k) {
        int len = k;
        Set<Integer> set = new HashSet<>();
        for (int i : rolls) {
            set.add(i);
            if (set.size() == k) {
                set = new HashSet<>();
                len++;
            }
        }
        return len;
    }
}
```