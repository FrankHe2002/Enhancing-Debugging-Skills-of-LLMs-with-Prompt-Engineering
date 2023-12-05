Fix:
```java
// Runtime: 996 ms (Top 5.13%) | Memory: 131.3 MB (Top 81.29%)
class SORTracker {

    private TreeMap<Integer, List<String>> map;
    private int queryNum;

    public SORTracker() {
        map = new TreeMap<>((a, b) -> (b - a));
        queryNum = 0;
    }

    public void add(String name, int score) {
        List<String> list = map.getOrDefault(score, new ArrayList<>());
        list.add(name);
        map.put(score, list);
    }

    public String get() {
        int index = queryNum;
        for (int score : map.keySet()) {
            if (index < map.get(score).size()) {
                queryNum++;
                return map.get(score).get(index);
            }
            index -= map.get(score).size();
        }
        return "";
    }
}
```