```java
import java.util.*;

class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Map<Integer, List<Integer>> timeToIndexes = new TreeMap<>();
        int m = meetings.length;
        for (int i = 0; i < m; i++) {
            timeToIndexes.putIfAbsent(meetings[i][2], new ArrayList<>());
            timeToIndexes.get(meetings[i][2]).add(i);
        }

        UF uf = new UF(n);
        uf.union(0, firstPerson);
        for (int time : timeToIndexes.keySet()) {
            Set<Integer> pool = new HashSet<>();

            for (int ind : timeToIndexes.get(time)) {
                int[] currentMeeting = meetings[ind];
                uf.union(currentMeeting[0], currentMeeting[1]);
                pool.add(uf.find(currentMeeting[0]));
                pool.add(uf.find(currentMeeting[1]));
            }
            for (int i : pool) if (! uf.connected(0, i)) uf.reset(i);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) if (uf.connected(i, 0)) ans.add(i);
        return ans;
    }

    private static class UF {
        int[] parent, rank;

        public UF(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);

            if (rootP == rootQ)
                return;

            if (rank[rootP] < rank[rootQ]) {
                parent[rootP] = rootQ;
            } else {
                parent[rootQ] = rootP;
                if (rank[rootP] == rank[rootQ]) {
                    rank[rootP]++;
                }
            }
        }

        public int find(int p) {
            while (parent[p] != p) {
                parent[p] = parent[parent[p]]; // update to point to its grandparent
                p = parent[p];
            }
            return p;
        }

        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }

        public void reset(int p) {
            parent[p] = p;
            rank[p] = 0;
        }
    }
}
```