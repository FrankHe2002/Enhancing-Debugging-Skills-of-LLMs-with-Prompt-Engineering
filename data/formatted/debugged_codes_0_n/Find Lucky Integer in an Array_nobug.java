```java
class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        System.out.print(map);
        int max = -1;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int temp = 0;
            if (e.getKey() == e.getValue()) {
                temp = e.getKey();
            }
            if (max < temp) {
                max = temp;
            }
        }
        return max;
    }
}
```