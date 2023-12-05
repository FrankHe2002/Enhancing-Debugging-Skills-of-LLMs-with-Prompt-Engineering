```java
class Solution {
    public int findFinalValue(int[] nums, int original) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums)
            if (i == original)
                original *= 2;
        return original;
    }
}
```