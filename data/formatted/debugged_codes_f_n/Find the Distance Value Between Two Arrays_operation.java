Fixed Code:
```java
class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int x = 0;
        for (int i : arr1) {
            boolean found = false;
            for (int j : arr2) {
                if (Math.abs(i - j) <= d) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                x++;
            }
        }
        return x;
    }
}
```