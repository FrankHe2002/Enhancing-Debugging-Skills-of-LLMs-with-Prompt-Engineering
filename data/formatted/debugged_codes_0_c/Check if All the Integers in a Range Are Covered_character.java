The bug in the code is a missing semicolon in the for loop header. 

Here is the fixed code:

```java
class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        boolean flag = false;
        for (int i = left; i <= right; i++) { // Added semicolon here
            for (int[] arr : ranges) {
                if (i >= arr[0] && i <= arr[1]) {
                    flag = true;
                    break;
                }
            }
            if (!flag) return false;
            flag = false;
        }

        return true;
    }
}
```

In the original code, there is a missing semicolon in the for loop header: `for (int i = left; i <= right i++)`. The semicolon is necessary to separate the three parts of the for loop header: initialization (`int i = left`), condition (`i <= right`), and iteration (`i++`). Without the semicolon, the code will not compile.

By adding the semicolon, the code will work as intended: it will iterate over each number from `left` to `right`. For each number, it will check if that number is within any of the ranges in the `ranges` array. If it finds a range that covers the current number, it sets the `flag` to true. If it doesn't find any covering range, it returns false. After iterating over all the numbers, if the flag is still false, it means that there is a gap in the coverage and the method returns false. If the flag is true, it means that all the numbers are covered and the method returns true.