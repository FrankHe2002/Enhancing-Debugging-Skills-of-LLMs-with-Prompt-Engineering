```java
class Solution {
    public boolean divideArray(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i : map.keySet()) {
            if (map.get(i) % 2 != 0) {
                return false;
            }
        }
        return true;
    }
}
```