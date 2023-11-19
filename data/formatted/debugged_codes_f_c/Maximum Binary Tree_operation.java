Buggy Code Explanation:
The buggy code has a compilation error due to the incorrect syntax in the line `int idx = / 1, max = Integer.MIN_VALUE;`. There is a misplaced forward slash, which should be a forward slash followed by an asterisk (`/*`). This indicates the beginning of a multiline comment. The error can be fixed by changing `/` to `/*`.

Additionally, there is a missing semicolon at the end of the statement inside the for loop. Adding a semicolon at the end of `for (int i = low; i <= high; ++ i)` corrects this syntax error.

Buggy Code Fix:
```java
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode root = construct(nums, 0, nums.length - 1);
        return root;
    }

    private TreeNode construct(int[] nums, int start, int end) {
        if (start > end)
            return null;
        if (start == end)
            return new TreeNode(nums[start]);

        int maxIdx = findMax(nums, start, end);
        TreeNode root = new TreeNode(nums[maxIdx]);

        root.left = construct(nums, start, maxIdx - 1);
        root.right = construct(nums, maxIdx + 1, end);

        return root;
    }

    private int findMax(int[] arr, int low, int high) {
        int idx = /* 1, */ max = Integer.MIN_VALUE;
        for (int i = low; i <= high; ++i)
            if (arr[i] > max) {
                max = arr[i];
                idx = i;
            }
        return idx;
    }
}
```