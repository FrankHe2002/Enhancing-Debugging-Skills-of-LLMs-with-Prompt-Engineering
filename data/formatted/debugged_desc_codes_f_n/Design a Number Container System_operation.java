Fix:
```java
class NumberContainers {

    Map<Integer, TreeSet<Integer>> map;
    Map<Integer, Integer> m;

    public NumberContainers() {
        map = new HashMap<>();
        m = new HashMap<>();
    }

    public void change(int index, int number) {
        if (m.containsKey(index)) {
            int currentNumber = m.get(index);
            map.get(currentNumber).remove(index);
            if (map.get(currentNumber).size() == 0) {
                map.remove(currentNumber);
            }
        }
        m.put(index, number);
        if (!map.containsKey(number)) {
            map.put(number, new TreeSet<>());
        }
        map.get(number).add(index);
    }

    public int find(int number) {
        if (!map.containsKey(number)) return -1;
        return map.get(number).first();
    }
}
```