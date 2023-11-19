The bug in the provided code is at the line `for (int i = 0; i > len; i++)`. The condition of the for loop is incorrect. It should be `i < len` instead of `i > len`. The current condition leads to the loop never executing, causing incorrect results.

Additionally, the code can be optimized by using a StringBuilder to construct the result instead of an ArrayList. This avoids the need to reverse the result list at the end.

To fix the bug and optimize the code, we need to change the condition of the for loop and update the code to use StringBuilder.

Fixed Code:
```java
// Runtime: 1 ms (Top 100.00%) | Memory: 42.4 MB (Top 98.61%)
class Solution {
    public int[] addNegabinary(int[] arr1, int[] arr2) {

        StringBuilder sb = new StringBuilder();
        int pointer_1 = arr1.length - 1;
        int pointer_2 = arr2.length - 1;

        int carry = 0;
        int current = 0;
        int sum = 0;

        while (pointer_1 >= 0 || pointer_2 >= 0) {

            int a = (pointer_1 >= 0) ? arr1[pointer_1] : 0;
            int b = (pointer_2 >= 0) ? arr2[pointer_2] : 0;

            sum = a + b + carry;
            if (sum == 3) {
                current = 1;
                carry = -1;
            } else if (sum == 2) {
                current = 0;
                carry = -1;
            } else if (sum == 1) {
                current = 1;
                carry = 0;
            } else if (sum == 0) {
                current = 0;
                carry = 0;
            } else if (sum == -1) {
                current = 1;
                carry = 1;
            }

            sb.append(current);
            pointer_1--;
            pointer_2--;
        }

        if (carry != 0)
            sb.append(1);
        if (carry == -1)
            sb.append(1);

        // Reverse the StringBuilder and convert to an array
        String reversed = sb.reverse().toString();
        int[] negaBinary = new int[reversed.length()];
        for (int i = 0