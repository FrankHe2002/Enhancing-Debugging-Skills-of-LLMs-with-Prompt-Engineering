The bug in the given code is in the `beautySum` method where the `charCount` array is incorrectly initialized with size 0. This will lead to a runtime error when trying to access elements of the array. To fix this bug, the `charCount` array should be initialized with the size of 26, representing the 26 lowercase English letters.

```java
public int beautySum(String s) {
    int sum = 0;

    for (int i = 0; i < s.length(); ++ i) {
        int[] charCount = new int[26]; // initialize charCount to all 0

        for (int j = i; j < s.length(); ++ j) {
            ++ charCount[s.charAt(j) - 'a'];

            // get beauty of substring from i to j
            int beauty = getMaxCount(charCount) - getMinCount(charCount);
            sum += beauty;
        }
    }

    return sum;
}
```