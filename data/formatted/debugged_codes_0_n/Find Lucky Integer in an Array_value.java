```java
// Runtime: 1 ms, faster than 94.78% | Memory: 39 MB, less than 95.25%
class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int max = -1;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getKey().equals(e.getValue())) {
                max = Math.max(max, e.getKey());
            }
        }
        return max;
    }
}
```