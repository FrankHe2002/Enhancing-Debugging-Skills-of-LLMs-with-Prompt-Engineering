```java
class Solution {
    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> temp = new TreeSet<>();
        for (int i : nums) {
            if (i % 2 == 1) {
                temp.add(i * 2);
            } else {
                temp.add(i);
            }
        }

        int md = temp.last() - temp.first();
        int m = 0;

        while (temp.size() > 0 && temp.last() % 2 == 0) {
            m = temp.last();
            temp.remove(m);
            temp.add(m / 2);
            md = Math.min(md, temp.last() - temp.first());
        }
        return md;
    }
}
```