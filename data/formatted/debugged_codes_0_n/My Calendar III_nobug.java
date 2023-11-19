```java
// Runtime: 121 ms (Top 51.80%) | Memory: 54.1 MB (Top 66.74%)
class MyCalendarThree {

    TreeMap<Integer, Integer> map;

    public MyCalendarThree() {
        map = new TreeMap<>();
    }

    public int book(int start, int end) {
        if (map.isEmpty()) {
            map.put(start, 1);
            map.put(end, - 1);
            return 1;
        }

        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);

        int res = 0;
        int sum = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            sum += e.getValue();
            res = Math.max(res, sum);
            if (e.getKey() >= end) {
                break;
            }
        }

        return res;
    }
}
```