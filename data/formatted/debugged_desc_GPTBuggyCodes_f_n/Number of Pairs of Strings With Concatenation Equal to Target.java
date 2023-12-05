Fix:

```java
class Solution {
    public int numOfPairs(String[] nums, String target) {

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    String concat = nums[i] + nums[j];
                    if (concat.equals(target)) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}
```