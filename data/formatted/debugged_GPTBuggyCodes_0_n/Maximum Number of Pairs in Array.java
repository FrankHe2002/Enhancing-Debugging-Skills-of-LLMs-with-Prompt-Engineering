```java
class Solution {
    public int[] numberOfPairs(int[] nums) {
        if (nums.length == 1)
            return new int[] {0, 1};

        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> checked = new HashSet<>(); // Added

        int pairs = 0;
        for (int i : nums) {
            if (!checked.contains(i)) { // Changed
                set.add(i);
                checked.add(i); // Added
            } else {
                set.remove(i); // Changed
                checked.add(i); // Added
                pairs++;
            }
        }

        return new int[] {pairs, set.size()};
    }
}
```