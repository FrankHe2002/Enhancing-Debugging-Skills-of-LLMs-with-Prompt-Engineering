```java
class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        int[] bits = new int[101];
        for (int n : nums1) bits[n] |= 0b100;
        for (int n : nums2) bits[n] |= 0b010;
        for (int n : nums3) bits[n] |= 0b001;
        List<Integer> result = new ArrayList();
        for (int i = bits.length - 1; i >= 0; i--)
            if (bits[i] == 0b111)
                result.add(i);
        return result;
    }
}
```