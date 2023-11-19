Bug Type: Missing a generic type argument in `new ArrayList(list)`

Reasoning: The bug is caused by the missing generic type argument in the statement `new ArrayList(list)`. In Java, when creating an instance of a parameterized class (such as `ArrayList`), it is necessary to specify the type argument in angle brackets (`<>`). This ensures type safety and allows the compiler to perform type checking. In this case, the type argument should be `Integer` because `list` contains elements of type `Integer`.

Fix: Add the generic type argument `Integer` to the `new ArrayList` statement.

Fixed Code:
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
            res.add(new ArrayList<>(list));
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