```java
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words)
            map.put(word, map.getOrDefault(word, 0) + 1);
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((a, b) -> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue());
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            queue.offer(entry);
            if (queue.size() > k) queue.poll();
        }
        List<String> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            list.add(0, queue.poll().getKey());
        }
        return list;
    }
}
```