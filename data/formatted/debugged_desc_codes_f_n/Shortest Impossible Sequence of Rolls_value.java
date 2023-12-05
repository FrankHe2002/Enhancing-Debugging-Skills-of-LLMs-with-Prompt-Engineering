```java
class Solution {
    public int shortestSequence(int[] rolls, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i : rolls) {
            set.add(i);
        }
        return k - set.size() + 1;
    }
}
```