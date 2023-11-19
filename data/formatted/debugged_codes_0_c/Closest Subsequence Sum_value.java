The bug in the provided Java code is in the `generate()` method. 

In the `generate()` method, when making the recursive calls, there is an error in the first parameter of the recursive calls. The correct value for the first parameter should be `i + 1` instead of `i + -1`. The current value causes the recursive call to never move forward to the next index, resulting in an infinite loop.

To fix the bug, change the first parameter value in the recursive calls of the `generate()` method from `i + -1` to `i + 1`. The updated code is as follows:

```java
void generate(int i, int end, int sum, List<Integer> listOfSubsetSums) {
    if (i == end) {
        listOfSubsetSums.add(sum);
        return;
    }
    generate(i + 1, end, sum + arr[i], listOfSubsetSums); // fix the recursive call
    generate(i + 1, end, sum, listOfSubsetSums); // fix the recursive call
}
```

This fix ensures that the program iterates through each index in the array correctly, generating all possible subset sums.