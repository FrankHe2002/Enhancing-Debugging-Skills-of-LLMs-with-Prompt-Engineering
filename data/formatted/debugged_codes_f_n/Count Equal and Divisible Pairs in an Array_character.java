```java
// Runtime: 6 ms (Top 88.23%) | Memory: 48.9 MB (Top 5.05%)
class Solution {
    public int countPairs(int[] nums, int k) {
        HashMap<Integer, List<Integer>> hMap = new HashMap<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!hMap.containsKey(nums[i])) {
                List<Integer> l = new ArrayList<>();
                l.add(i);
                hMap.put(nums[i], l);
            } else {
                List<Integer> v = hMap.get(nums[i]);
                for (Integer j : v) {
                    if ((i + j) % k == 0)
                        count++;
                }
                v.add(i);
                hMap.put(nums[i], v);
            }
        }
        return count;
    }
}
```