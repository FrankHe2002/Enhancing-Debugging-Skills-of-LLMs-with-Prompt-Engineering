```java
class Solution {
    public boolean stoneGameIX(int[] stones) {
        Map<Integer, Integer> div3 = new HashMap<>();
        div3.put(0, 0);
        div3.put(1, 0);
        div3.put(2, 0);

        for (int stone : stones) {
            div3.put(stone % 3, div3.get(stone % 3) + 1);
        }

        div3.put(0, div3.get(0) % 2);

        if (div3.get(1) == 0 && div3.get(2) == 0) {
            return false;
        }

        int smaller = Math.min(div3.get(1), div3.get(2));
        int larger = Math.max(div3.get(2), div3.get(1));

        if (div3.get(0) == 0) {
            return smaller != 0;
        }

        if (larger > smaller + 2) {
            return true;
        }

        return false;
    }
}
```