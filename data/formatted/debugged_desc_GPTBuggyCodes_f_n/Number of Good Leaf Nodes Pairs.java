```java
class Solution {
    static int res;

    public int countPairs(TreeNode root, int distance) {
        res = 0;
        rec(root, distance);
        return res;
    }

    static List<Integer> rec(TreeNode root, int dist) {
        if (root == null)
            return new ArrayList<>();

        List<Integer> left = rec(root.left, dist);
        List<Integer> right = rec(root.right, dist);
        for (int i : left) {
            for (int j : right) {
                if (i + j <= dist) {
                    res++;
                }
            }
        }

        List<Integer> oneUp = new ArrayList<>();
        for (int i : left) {
            if (++i < dist) {
                oneUp.add(i);
            }
        }
        for (int i : right) {
            if (++i < dist) {
                oneUp.add(i);
            }
        }
        return oneUp.isEmpty() ? Arrays.asList(1) : oneUp;
    }
}
```