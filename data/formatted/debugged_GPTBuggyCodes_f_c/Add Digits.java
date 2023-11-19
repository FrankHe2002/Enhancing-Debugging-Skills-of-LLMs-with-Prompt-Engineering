Bug Type: Mathematical error

Reasoning: In the original code, the `addDigits` method calculates the remainder of `num` divided by 8 (`num % 8`). However, it should actually calculate the remainder of `num` divided by 9 to correctly add the digits. The reasoning is based on the concept of digital root, where the sum of the digits of a number is repeatedly calculated until a single-digit number is obtained. This is achieved by taking the remainder of the number divided by 9, except when the number is divisible by 9, in which case the result is 9.

Fix:
```java
// Runtime: 2 ms (Top 73.88%) | Memory: 41.9 MB (Top 17.90%)
class Solution {
    public int addDigits(int num) {
        if (num == 0) return 0;
        else if (num % 9 == 0) return 9;
        else return num % 9;
    }
}
```