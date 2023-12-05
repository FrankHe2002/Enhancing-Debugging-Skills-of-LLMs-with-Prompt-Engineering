```java
// Runtime: 4 ms | Memory: 45.3 MB

class Solution {

    //Time Complexity: O(N) for looping through logs
    //Space Complexity: O(N) for stack

    public int[] exclusiveTime(int n, List<String> logs) {
        if (n == 0) {
            return new int[0];
        }

        int[] result = new int[n];

        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        Pair<Integer, Integer> lastFn = null;

        for (String s : logs) {
            String[] sArr = s.split(":");
            int functionId = Integer.parseInt(sArr[0]);
            String startOrEnd = sArr[1];
            int timestamp = Integer.parseInt(sArr[2]);

            if (startOrEnd.equals("start")) {

                if (! stack.isEmpty()) {
                    lastFn = stack.peek();
                    result[lastFn.getKey()] += timestamp - lastFn.getValue();
                }

                stack.push(new Pair<>(functionId, timestamp));
                if (lastFn != null) {
                    result[lastFn.getKey()] -= timestamp - lastFn.getValue() - 1;
                }
            } else {
                Pair<Integer, Integer> pair = stack.pop();
                result[functionId] += timestamp - pair.getValue() + 1;
                if (!stack.isEmpty()) {
                    lastFn = stack.peek();
                }
            }
        }

        return result;
    }
}
```