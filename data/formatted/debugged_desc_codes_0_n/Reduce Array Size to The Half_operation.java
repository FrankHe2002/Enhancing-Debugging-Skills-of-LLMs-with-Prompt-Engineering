```java
class Solution {
    public int minSetSize(int[] arr) {
        int size = arr.length;
        int deletedSize = 0;
        int countIteration = 0;
        Map<Integer, Integer> hashMap = new HashMap<>();
        Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue()); // Fixed typo

        for (int i = 0; i < size; i++) {
            if (hashMap.containsKey(arr[i])) // Changed != null to containsKey
                hashMap.put(arr[i], hashMap.get(arr[i]) + 1);
            else
                hashMap.put(arr[i], 1);
        }

        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            queue.add(entry);
        }

        while (!queue.isEmpty()) { // Removed space between ! and queue
            int totalOccurrence = queue.poll().getValue(); // Corrected spelling of Occurrence
            deletedSize += totalOccurrence;
            countIteration++;
            if (deletedSize >= size / 2)
                return countIteration;
        }
        return countIteration;
    }
}
```