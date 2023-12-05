**Code Description:**
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target. Each number in candidates may only be used once in the combination.

**Constraints:**
    - 1 <= candidates.length <= 100
    - 1 <= candidates[i] <= 50
    - 1 <= target <= 30

**Code:**
```java
// Runtime: 12 ms (Top 12.41%) | Memory: 43.5 MB (Top 81.01%)
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        // O(nlogn)
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

**Bug Type:**
The bug is a logical error in the helper method's 'for' loop conditions. The conditions involving visited[] array are not correctly implemented, leading to incorrect output for the combinationSum2.

**Explanation:**
- The condition `if (visited[i + 1])` is incorrect as it is trying to address accessing outside the array bounds (`i + 1`).
- The visited array is zero-indexed, so the correct access should be `visited[i]`.

**Fix:**
1. Update `if (visited[i + 1])` to `if (visited[i])`.
2. Update `if (i > 0 && candidates[i] == candidates[i - 1] && ! visited[i - 1])` to `if (i > 0 && candidates[i] == candidates[i - 1] && ! visited[i - 1])`.

**Fixed Code:**
```java
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