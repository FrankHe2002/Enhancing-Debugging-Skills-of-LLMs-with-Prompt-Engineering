Bug Type: Logic Error

Reasoning: The bug occurs in the `numberOfPairs` method. The issue is with how pairs are being counted. The current code incorrectly adds an element to the set when a pair is found, resulting in incorrect counts. To fix this, we need to remove the line `set.add(i);` inside the `else` block because the element is already present in the set, indicating a pair has been found.

Fixed Code:
```java
// Runtime: 4 ms (Top 21.09%) | Memory: 42.4 MB (Top 76.38%)
class Solution {
    public int[] numberOfPairs(int[] nums) {

        if (nums.length == 1)
            return new int[] {0, 1};

        HashSet<Integer> set = new HashSet<>();

        int pairs = 0;
        for (int i : nums) {
            if (!set.contains(i)) {
                set.add(i); // No pair present
            } else {
                pairs++;
            }
        }

        return new int[] {pairs, set.size()};
    }
}
```