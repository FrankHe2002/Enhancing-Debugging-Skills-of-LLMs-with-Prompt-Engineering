```java
class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        int result = 0;
        for (int i : map.keySet())
            if (k < 0 || k > 0 && map.containsKey(i + k))
                result++;
        return result;
    }
}
```