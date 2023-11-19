Bug type: Off-by-one error

Reasoning:
- The code calculates the string "s" by recursively calling the "func" method.
- The base case of the recursive function is when "i" is zero, in which case "0" is returned.
- Otherwise, the recursive call is made with "i" decremented by 1, and the returned string is concatenated with "1" and the reverse of the inverted result of the recursive call.
- The resulting string "s" is then used to retrieve the character at index "k - 1".

The bug:
- The bug lies in the calculation of "s" for the "findKthBit" method.
- The recursive "func" method calculates the string "s" starting from "func(n-1)".
- However, the usage of "func(n-1)" implies that the input "n" should be decremented before being passed to "func".
- Therefore, the line "String s = func(n - 1);" should be changed to "String s = func(n);" to correctly calculate the string "s".

Fix:
```java
// Runtime: 2755 ms (Top 5.21%) | Memory: 238.8 MB (Top 5.21%)
class Solution {
    private String invert(String s) {
        char[] array = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (array[i] != '1') {
                array[i] = '0';
            } else {
                array[i] = '1';
            }
        }
        return new String(array);
    }

    private String reverse(String s) {
        StringBuilder str = new StringBuilder(s);
        return str.reverse().toString();
    }

    private String func(int i) {
        if (i == 0) {
            return "0";
        }
        return func(i - 1) + "1" + reverse(invert(func(i - 1)));
    }

    public char findKthBit(int n, int k) {
        String s = func(n);
        return s.charAt(k - 1);
    }
}
```