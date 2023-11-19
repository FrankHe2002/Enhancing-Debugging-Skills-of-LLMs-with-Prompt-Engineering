Bug Type: Syntax Error

Reasoning: In the provided code, there is a syntax error in the line `max = Math.max(arr[1], max);`. The correct index to access the `arr` array should be `arr[i]` instead of `arr[1]`. The current code mistakenly uses the index `1` instead of the loop variable `i`.

Fix:
```java
// Runtime: 0 ms (Top 100.00%) | Memory: 40.9 MB (Top 81.61%)
class Solution {
    public int maxChunksToSorted(int[] arr) {
        int max = 0, count = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
            if (i == max) count++;
        }
        return count;
    }
}
```