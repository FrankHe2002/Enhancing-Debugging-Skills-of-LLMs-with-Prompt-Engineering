Explanation:
The original code has a logical error in the condition for checking if a number is a single-digit number or divisible by 10. The condition `(num % 10 != 0 || num < 10)` is incorrect and does not capture the requirement to reverse a number and compare the result. Instead, it only checks if the number is divisible by 10 or is a single-digit number, which does not fulfill the problem's requirement.

Fix:
```java
class Solution {
    public boolean isSameAfterReversals(int num) {
        int reversed1 = reverseDigits(num);
        int reversed2 = reverseDigits(reversed1);
        return reversed2 == num;
    }

    private int reverseDigits(int num) {
        int reversed = 0;
        while (num != 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }
        return reversed;
    }
}
```