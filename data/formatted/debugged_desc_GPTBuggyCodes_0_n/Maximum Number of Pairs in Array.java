```java
class Solution {
    public int[] numberOfPairs(int[] nums) {

        if (nums.length == 1)
            return new int[] {0, 1};

        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> pairsSet = new HashSet<>();

        int pairs = 0;
        for (int i : nums) {
            if (! set.contains(i)) {
                set.add(i);
            } else {
                if (!pairsSet.contains(i)) {
                    pairsSet.add(i);
                    pairs++;
                }
                set.remove(i);
            }
        }

        return new int[] {pairs, set.size()};
    }
}
```