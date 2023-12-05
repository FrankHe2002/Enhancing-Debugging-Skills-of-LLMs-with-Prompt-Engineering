```java
class Solution {
    public int findSpecialInteger(int[] arr) {
        int comp = arr.length / 4;
        for (int i : arr) {
            int count = 0;
            for (int j : arr) {
                if (j == i) {
                    count++;
                }
            }
            if (count > comp) {
                return i;
            }
        }
        return 0;
    }
}
```