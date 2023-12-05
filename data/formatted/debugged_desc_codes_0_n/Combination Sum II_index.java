```java
// Runtime: 2 ms (Top 99.99%) | Memory: 39.3 MB (Top 99.99%)
import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        boolean[] visited = new boolean[candidates.length];
        helper(res, path, candidates, visited, target, 0);
        return res;
    }

    private void helper(List<List<Integer>> res,
                        List<Integer> path, int[] candidates,
                        boolean[] visited, int remain, int currIndex
    ) {
        if (remain == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (remain < 0) {
            return;
        }

        for (int i = currIndex; i < candidates.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && candidates[i] == candidates[i - 1] && !visited[i - 1]) {
                continue;
            }
            int curr = candidates[i];
            path.add(curr);
            visited[i] = true;
            helper(res, path, candidates, visited, remain - curr, i + 1);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }
}
```