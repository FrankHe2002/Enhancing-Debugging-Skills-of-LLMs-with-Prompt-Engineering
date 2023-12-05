```java
// Runtime: 421 ms (Top 69.74%) | Memory: 172.7 MB (Top 82.56%)
class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {

        PriorityQueue<int[]> availableServer = new PriorityQueue<int[]>((a, b) -> (a[1] == b[1] ? (a[0] - b[0]) : (a[1] - b[1])));
        for (int i = 0; i < servers.length; i++) {
            availableServer.add(new int[] {i, servers[i]});
        }

        PriorityQueue<int[]> processingServer = new PriorityQueue<int[]>(
                (a, b) ->

                        (
                                a[2] != b[2] ? a[2] - b[2] : 
                                        a[1] != b[1] ? a[1] - b[1] : 
                                                a[0] - b[0] 
                        )
        );

        int[] result = new int[tasks.length];

        for (int i = 0; i < tasks.length; i++) {
            while (! processingServer.isEmpty() && processingServer.peek()[2] <= i) {
                int serverIndex = processingServer.remove()[0];
                availableServer.add(new int[] {serverIndex, servers[serverIndex]});
            }
            int currentTaskTimeRequired = tasks[i];
            int freeTime = currentTaskTimeRequired;
            int[] server;
            if (! availableServer.isEmpty()) {
                server = availableServer.remove();
                freeTime += i;
            } else {
                server = processingServer.remove();
                freeTime += server[2];
            }
            int serverIndex = server[0];
            processingServer.add(new int[] {serverIndex, servers[serverIndex], freeTime});
            result[i] = serverIndex;
        }
        return result;

    }
}
```