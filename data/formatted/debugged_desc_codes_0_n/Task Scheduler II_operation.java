```java
class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        HashMap<Integer, Long> map = new HashMap<>();
        long day = 0;

        for (int item : tasks) {
            if (map.containsKey(item) && map.get(item) > day) {
                day = map.get(item);
            }

            if (day - map.getOrDefault(item, 0) < space) {
                day = map.getOrDefault(item, 0) + space;
            }

            day++;
            map.put(item, day);
        }

        return day;
    }
}
```