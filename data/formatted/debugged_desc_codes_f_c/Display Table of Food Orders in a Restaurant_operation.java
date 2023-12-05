```java
// Runtime: 157 ms (Top 14.06%) | Memory: 126.7 MB (Top 62.50%)
class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>> ans = new ArrayList<>();
        List<String> head = new ArrayList<>();
        head.add("Table");
        Map<Integer, Map<String, Integer>> map = new TreeMap<>();
        for (List<String> s : orders) {
            if (!head.contains(s.get(2))) {
                head.add(s.get(2));
            }
            int tbl = Integer.parseInt(s.get(1));
            map.putIfAbsent(tbl, new TreeMap<>());
            Map<String, Integer> m = map.get(tbl);
            m.put(s.get(2), m.getOrDefault(s.get(2), 0) + 1);
        }
        List<String> foods = new ArrayList<>(head.subList(1, head.size()));
        Collections.sort(foods);
        head = new ArrayList<>(head);
        head.addAll(1, foods);
        ans.add(head);

        for (Map.Entry<Integer, Map<String, Integer>> entry : map.entrySet()) {
            List<String> l = new ArrayList<>();
            l.add(entry.getKey() + "");
            Map<String, Integer> m = entry.getValue();
            for (int i = 1; i < head.size(); i++) {
                if (m.containsKey(head.get(i))) {
                    l.add(m.get(head.get(i)) + "");
                } else {
                    l.add("0");
                }
            }
            ans.add(l);
        }
        return ans;
    }
}
```