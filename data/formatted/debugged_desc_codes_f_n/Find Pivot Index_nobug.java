```java
// Runtime: 1 ms (Top 100.00%) | Memory: 43.2 MB (Top 91.78%)
class Solution {
    public int pivotIndex(int[] nums) {

        int leftsum = 0;
        int rightsum = 0;

        for (int i = 1; i < nums.length; i++) rightsum += nums[i];

        if (leftsum == rightsum) return 0;

        for (int i = 0; i < nums.length; i++) { // fixed condition from i = 1 to i = 0
            leftsum += nums[i];
            if (leftsum == rightsum) return i;
            rightsum -= nums[i + 1]; // fixed to add nums[i + 1]
        }
        return - 1;
    }
}
```