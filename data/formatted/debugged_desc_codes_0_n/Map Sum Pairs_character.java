```java
class MapSum {
    private Map<String, Integer> map;

    public MapSum() {
        this.map = new HashMap<>();
    }

    public void insert(String key, int val) {
        int diff = val - map.getOrDefault(key, 0);
        int k = key.length();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sb.append(key.charAt(i));
            String prefix = sb.toString();
            map.put(prefix, map.getOrDefault(prefix, 0) + diff);
        }
    }

    public int sum(String prefix) {
        return this.map.getOrDefault(prefix, 0);
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
```