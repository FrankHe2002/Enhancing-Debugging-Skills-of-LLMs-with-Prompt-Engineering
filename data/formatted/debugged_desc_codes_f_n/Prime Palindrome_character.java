```java
// Prime Palindrome
// Leetcode problem: https://leetcode.com/problems/prime-palindrome/
class Solution {
    public int primePalindrome(int n) {
        while (true) {
            if (isPrime(n) && isPalindrome(n)) {
                return n;
            }
            n++;
        }
    }
    private boolean isPrime(int n) {
        if (n < 2 || n % 2 == 0 && n != 2) {
            return n == 2;
        }
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    private boolean isPalindrome(int n) {
        String s = String.valueOf(n);
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
```