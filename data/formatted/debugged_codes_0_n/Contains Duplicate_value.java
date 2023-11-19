```java
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            hs.add(nums[i]);
            if (hs.contains(nums[i])) {
                return true;
            }
        }
        return false;
    }
}
```