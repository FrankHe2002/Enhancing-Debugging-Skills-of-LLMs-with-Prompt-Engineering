Bug type: Syntactic error

Reasoning: When declaring the method `containsDuplicate`, there is a syntax error in the method signature. The opening bracket after `containsDuplicate` is missing, and the type of the parameter `int[] nums` is incorrect. The correct syntax for the method declaration should be `containsDuplicate(int[] nums)`.

Fix:
```java
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            hs.add(nums[i]);
            if (hs.contains(nums[i + 1])) {
                return true;
            }
        }
        return false;
    }
}
```