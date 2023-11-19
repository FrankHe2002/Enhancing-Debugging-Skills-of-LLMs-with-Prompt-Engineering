```java
class Solution {
    long max = 0, res = 0;

    public int countHighestScoreNodes(int[] parents) {
        Map<Integer, List<Integer>> hm = new HashMap<>();
        for (int i = 0; i < parents.length; i++) {
            hm.computeIfAbsent(parents[i], x -> new ArrayList<>()).add(i);
        }
        dfs(0, parents.length, hm);
        return (int) res;
    }

    int dfs(int s, int n, Map<Integer, List<Integer>> hm) {
        int sum = 1;
        long mult = 1L;
        for (int child : hm.getOrDefault(s, new ArrayList<>())) {
            int count = dfs(child, n, hm);
            sum += count;
            mult *= count;
        }
        mult *= (s == 0 ? 1L : n - sum);
        if (mult > max) {
            max = mult;
            res = 1;
        } else if (mult == max) {
            res++;
        }
        return sum;
    }
}
```
