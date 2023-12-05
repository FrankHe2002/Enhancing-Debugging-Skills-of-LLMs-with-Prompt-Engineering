```java
// Runtime: 107 ms (Top 43.06%) | Memory: 139.6 MB (Top 38.28%)
class Solution {
    public int maximumInvitations(int[] favorite) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < favorite.length; i++) {
            graph.add(new ArrayList<>());
        }

        int answer = 0;

        boolean[] added = new boolean[favorite.length];

        for (int i = 0; i < favorite.length; i++) {
            if (!added[i]) {
                List<Integer> cycle = new ArrayList<>();
                int index = i;
                while (!added[index]) {
                    added[index] = true;
                    cycle.add(index);
                    index = favorite[index];
                }
                answer = Math.max(answer, cycle.size());

                if (cycle.size() > 1) {
                    for (int idx : cycle) {
                        List<Integer> currentGraph = graph.get(idx);
                        for (int person : cycle) {
                            if (idx != person) {
                                currentGraph.add(person);
                            }
                        }
                    }
                }
            }
        }

        int[] connected = new int[favorite.length];
        Arrays.fill(connected, -1);

        for (int i = 0; i < favorite.length; i++) {
            answer = Math.max(answer, getLongestCycle(graph, i, connected));
        }

        return answer;
    }

    private int getLongestCycle(List<List<Integer>> graph, int index, int[] connected) {
        if (connected[index] != -1) {
            return 0;
        }
        int result = 0;
        connected[index] = 1;
        for (int i : graph.get(index)) {
            result = Math.max(result, 1 + getLongestCycle(graph, i, connected));
        }
        connected[index] = 0;
        return result;
    }
}
```