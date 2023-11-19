Bug Type: Union Find Logic Error

Reasoning:
1. The code uses the union-find algorithm to group people who can communicate with each other.
2. It initializes the union-find data structure with `n` nodes, where each node represents a person.
3. It then iterates through the meetings and unions the two people from each meeting.
4. After each meeting, it checks if the two people know the secret by checking if they are connected to the first person (assuming that the first person knows the secret).
5. If they are not connected, it resets their union.
6. Finally, it returns a list of people who know the secret based on whether they are connected to the first person.

Potential Bug:
The bug in the code lies in the union-find logic. The code incorrectly handles the rank of the parent nodes in the `union` method. It increments the rank of the wrong root in the else condition of `if (rank[rootP] < rank[rootQ])`. It should increment the rank of the root that is being set as the parent, i.e., `rootQ`, not `rootP`.

Fix:
To fix the bug, we need to change the line `rank[rootP]++` to `rank[rootQ]++` in the `union` method of the `UF` class.

Updated Code:
```java
// Runtime: 100 ms (Top 53.2%) | Memory: 108.54 MB (Top 41.1%)

class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {

        // create <time, index> map
        Map<Integer, List<Integer>> timeToIndexes = new TreeMap<>();
        int m = meetings.length;
        for (int i = 0; i < m; i++) {
            timeToIndexes.putIfAbsent(meetings[i][2], new ArrayList<>());
            timeToIndexes.get(meetings[i][2]).add(i);
        }

        UF uf = new UF(n);
        // base
        uf.union(0, firstPerson);

        // for every time we have a pool of people that talk to each other
        // if someone knows a secret proir to this meeting - all pool will too
        // if not - reset unions from this pool
        for (int time : timeToIndexes.keySet()) {
            Set<Integer> pool = new HashSet<>();

            for (int ind : timeToIndexes.get(time)) {
                int[]