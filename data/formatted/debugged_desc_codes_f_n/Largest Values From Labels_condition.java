```java
class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        PriorityQueue<Pair<Integer, Integer>> maxHeap =
                new PriorityQueue<>((a, b) -> Integer.compare(b.getKey(), a.getKey()));
        Map<Integer, Integer> labelLimitMap = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            maxHeap.add(new Pair<Integer, Integer>(values[i], labels[i]));
        }
        
        int sum = 0;
        while (!maxHeap.isEmpty() && numWanted != 0) {
            Pair<Integer, Integer> item = maxHeap.poll();
            int label = item.getValue();
            if (labelLimitMap.containsKey(label)) {
                if (labelLimitMap.get(label) == useLimit) {
                    continue;
                } else {
                    labelLimitMap.put(label, labelLimitMap.get(label) + 1);
                    sum += item.getKey();
                    numWanted--;
                }
            } else {
                labelLimitMap.put(label, 1);
                sum += item.getKey();
                numWanted--;
            }
        }
        return sum;
    }
}
```