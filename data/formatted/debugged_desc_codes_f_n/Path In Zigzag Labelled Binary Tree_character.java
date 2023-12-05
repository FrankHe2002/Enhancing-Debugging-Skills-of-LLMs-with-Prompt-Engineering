Fix:
```java
class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        int level, min, max, parent, i = label;
        List<Integer> ans = new ArrayList<Integer>();

        ans.add(i);

        while (i > 1) {
            level = (int) (Math.log(i) / Math.log(2));
            if (level % 2 == 0) {
                max = (int) Math.pow(2, level) - 1;
                min = (int) Math.pow(2, level - 1);
                parent = (int) (max - i / 2 + min / 2);
            } else {
                min = (int) Math.pow(2, level - 1);
                max = (int) Math.pow(2, level) - 1;
                parent = (int) (min - ((i - max) / 2));
            }

            ans.add(0, parent);
            i = parent;
        }
        return ans;
    }
}
```