class Solution {
    public int[] processQueries(int[] queries, int m) {
        int[] results = new int[queries.length];
        ArrayList<Integer> permutations = new ArrayList<Integer>();
        for (int i = 0; i < m; i++)
            permutations.add(i + 1);
        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            for (int j = 0; j < permutations.size(); j++)
                if (permutations.get(j) == query) {
                    results[i] = j;
                    int temp = permutations.get(j);
                    permutations.remove(j);
                    permutations.add(0, temp);
                    break;
                }
        }

        return results;

    }
}