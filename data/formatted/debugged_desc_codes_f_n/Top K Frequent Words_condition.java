Fix:
```java
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words)
            map.put(word, map.getOrDefault(word, 0) + 1);
        PriorityQueue<String> queue = new PriorityQueue<>((a, b) -> map.get(a).equals(map.get(b)) ? b.compareTo(a) : map.get(a) - map.get(b));
        queue.addAll(map.keySet());
        List<String> result = new ArrayList<>();
        while (k > 0) {
            result.add(queue.poll());
            k--;
        }
        return result;
    }
}
```