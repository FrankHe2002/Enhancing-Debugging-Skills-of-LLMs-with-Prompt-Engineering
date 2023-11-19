```java
class Solution {
    public int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }

    public void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (rank[a] > rank[b]) {
            parent[b] = a;
            rank[a] += rank[b];
        } else {
            parent[a] = b;
            rank[b] += rank[a];
        }
    }

    int parent[];
    int rank[];

    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        List<Boolean> ans = new ArrayList<Boolean>();
        parent = new int[n + 1];
        rank = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (int th = threshold + 1; th <= n; th++) {
            int mul = 1;
            while (mul * th <= n) {
                union(th, mul * th);
                mul++;
            }
        }

        for (int[] query : queries) {
            ans.add((find(query[0]) == find(query[1])));
        }
        return ans;
    }
}
```