Bug Type: Logical Error

Reasoning:
The provided code implements a recursive function `func` that generates a string based on a given parameter `i`. The function recursively calls itself with a decreasing value of `i` and concatenates "1" with the reversed and inverted result of the recursive call. The `findKthBit` method then uses the `func` function to generate a string and returns the character at the `k`-th index.

The bug lies in the `invert` method. The original implementation mistakenly checks if the current character is not equal to '1' and assigns '0' to it. However, based on the logic described, the intent is to invert all characters in the string. Therefore, the condition should check if the current character is not equal to '0' and assign '1' to it.

Additionally, the `reverse` method can be simplified by directly calling `str.reverse().toString()` instead of storing it in a `StringBuilder` object.

Fix:
```java
class Solution {
    private String invert(String s) {
        char[] array = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (array[i] != '0') { // change from '1' to '0'
                array[i] = '1';    // change from '0' to '1'
            } else {
                array[i] = '0';
            }
        }
        return new String(array);
    }

    private String func(int i) {
        if (i == 0) {
            return "0";
        }
        return func(i - 1) + "1" + invert(func(i - 1)); // reversed removed
    }

    public char findKthBit(int n, int k) {
        String s = func(n - 1);
        return s.charAt(k - 1);
    }
}
```

Fixed Code:
```java
// Runtime: 2755 ms (Top 5.21%) | Memory: 238.8 MB (Top 5.21%)
class Solution {
    private String invert(String s) {
        char[] array = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (array[i] != '0') { // fixed bug here
                array[i] = '1';
            } else {
                array[i] = '0';
            }
        }
        return new String(array);
