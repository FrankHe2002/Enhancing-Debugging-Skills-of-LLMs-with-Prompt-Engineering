```java
class Solution {

    public int find(int x, int[] parent) {

        if (parent[x] == x)
            return x;

        //Optimising by placing the same parent for all the elements to reduce reduntant calls
        return parent[x] = find(parent[x], parent);
    }

    public void union(int a, int b, int[] parent, int[] rank) {

        a = find(a, parent);
        b = find(b, parent);

        //Using Rank optimisation
        if (rank[a] > rank[b]) {
            parent[b] = a;
            rank[a] += rank[b];
        } else {
            parent[a] = b;
            rank[b] += rank[a];
        }

        //parent[b] = a;
    }

    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {

        List<Boolean> ans = new ArrayList<Boolean>();
        int[] parent = new int[n + 1];
        int[] rank = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            //Each element is its own parent
            parent[i] = i;
            //At beginning each element has rank 1
            rank[i] = 1;
        }

        // Finding the possible divisors with pairs above given threshold
        for (int th = threshold + 1; th <= n; th++) {

            int mul = 1;
            while (mul * th <= n) {
                //If possible pair then making a union of those paired element
                union(th, mul * th, parent, rank);
                mul++;
            }
        }

        //Generating ans for all possible queries
        for (int[] query : queries) {
            ans.add((find(query[0], parent) == find(query[1], parent)));
        }
        return ans;
    }
}
```