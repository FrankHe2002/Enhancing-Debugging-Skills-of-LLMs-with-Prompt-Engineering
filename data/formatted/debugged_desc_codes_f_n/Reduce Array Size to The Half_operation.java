```java
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int minSetSize(int[] arr) {
        int size = arr.length;
        int deletedSize = 0;
        int countIteration = 0;
        Map<Integer, Integer> hashMap = new HashMap<>();
        Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        for (int i = 0; i < size; i++) {
            if (hashMap.containsKey(arr[i]))
                hashMap.put(arr[i], hashMap.get(arr[i]) + 1);
            else
                hashMap.put(arr[i], 1);
        }

        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            queue.add(entry);
        }

        while (!queue.isEmpty()) {
            int totalOccurrence = queue.poll().getValue();
            deletedSize += totalOccurrence;
            countIteration++;
            if (deletedSize >= size / 2)
                return countIteration;
        }
        return countIteration;
    }
}
```