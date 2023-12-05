```java
// Runtime: 12 ms (Top 12.82%) | Memory: 44.3 MB (Top 18.67%)
class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int max = -1;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getKey() == e.getValue()) {
                if (max < e.getKey()) {
                    max = e.getKey();
                }
            }
        }
        return max;
    }
}
```