Bug type: Compilation error

Reasoning process:
1. The code is giving a compilation error because the comparator used in the `Arrays.sort()` method is not correctly implemented.
2. The comparator is comparing `i0` and `i2` variables, which are not declared. It should be comparing `i0` and `i1` instead.

Fix:
```java
class Solution {
    public int findMinArrowShots(int[][] points) {

        int minNumArrows = 1;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] i1, int[] i2) {
                if (i1[0] < i2[0])
                    return - 1;
                else if (i1[0] > i2[0])
                    return 1;
                return 0;
            }
        });

        // Rest of the code...
    }

    // Rest of the code...
}
```