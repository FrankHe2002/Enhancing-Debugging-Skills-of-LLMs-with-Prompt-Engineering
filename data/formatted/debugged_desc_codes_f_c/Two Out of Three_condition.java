The bug in the provided code is a logical error in the last for loop condition. The condition to end the for loop should be "i >= 0" to iterate through the entire bits array, but the current condition "i < 0" will prevent the loop from executing, resulting in an empty list.

The potential refactored and fixed code in markdown would be:

```java
// Runtime: 2 ms (Top 97.56%) | Memory: 46.7 MB (Top 58.76%)
class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        int[] bits = new int[101];
        for (int n : nums1) bits[n] |= 0b110;
        for (int n : nums2) bits[n] |= 0b101;
        for (int n : nums3) bits[n] |= 0b011;
        List<Integer> result = new ArrayList();
        for (int i = bits.length - 1; i >= 0; i--)
            if (bits[i] == 0b111)
                result.add(i);
        return result;
    }
}
```
Fixed the for loop condition to iterate from "i = bits.length - 1" to "i >= 0".