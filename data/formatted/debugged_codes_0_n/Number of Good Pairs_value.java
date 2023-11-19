```java
// Runtime: 2 ms (Top 85.5%) | Memory: 37.9 MB (Top 18.8%)

class Solution {
    public int numIdenticalPairs(int[] nums) {
        int len = nums.length;
        int counter = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] == nums[j]) {
                    counter++;
                }
            }

        }
        return counter;

    }
}
```