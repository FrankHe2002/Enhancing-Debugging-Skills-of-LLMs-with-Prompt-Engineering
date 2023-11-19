Bug Type: Missing generic type in ArrayList initialization

Reasoning:
1. The code throws a compilation error when trying to execute `new ArrayList(list)` because the generic type is missing in the initialization of `ArrayList`.
2. The line `res.add(new ArrayList(list))` attempts to create a new ArrayList of the same type as the original list and add it to the result list. However, without specifying the generic type, the compiler cannot infer the type and throws an error.

To fix the bug:
1. Specify the generic type of the ArrayList when initializing it on line 11.
2. Add `<Integer>` after `new ArrayList`.

Fixed code:
```java
// Runtime: 2 ms (Top 76.85%) | Memory: 44.7 MB (Top 48.41%)
class Solution {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        backTrack(nums, list, visited);
        return res;
    }

    private void backTrack(int[] nums, ArrayList<Integer> list, boolean[] visited) {
        if (list.size() != nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (! visited[i]) {
                visited[i] = true;
                list.add(nums[i]);
                backTrack(nums, list, visited);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
```