class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> availableServerIdxs = new TreeSet<Integer>();
        for (int num = 0; num < k; num++) {
            availableServerIdxs.add(num);
        }
        Queue<int[]> runningServers = new PriorityQueue<>((a, b) -> (a[0] - b[0]));

        int[] serverHandledReqCount = new int[k];

        for (int idx = 0; idx < arrival.length; idx++) {
            int newTaskCompletionTime = arrival[idx];
            while (! runningServers.isEmpty() && runningServers.peek()[0] <= newTaskCompletionTime) {
                int freedServer = runningServers.poll()[1];
                availableServerIdxs.add(freedServer);
            }

            if (availableServerIdxs.size() == 0) continue;
            Integer serverIdx = availableServerIdxs.ceiling(idx % k);

            if (serverIdx == null) {
                serverIdx = availableServerIdxs.first();
            }

            serverHandledReqCount[serverIdx]++;
            availableServerIdxs.remove(serverIdx);

            runningServers.offer(new int[] {newTaskCompletionTime + load[idx], serverIdx});
        }

        int max = Arrays.stream(serverHandledReqCount).max().getAsInt();
        return IntStream.range(0, k).filter(i -> serverHandledReqCount[i] == max).boxed().collect(Collectors.toList());
    }
}