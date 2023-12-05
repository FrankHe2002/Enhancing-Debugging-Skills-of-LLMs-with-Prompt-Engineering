```java
class Solution {
    public String breakPalindrome(String palindrome) {

        int left = 0;
        int right = palindrome.length() - 1;

        if (palindrome.length() == 1)
            return "";

        while (left < right) {

            char c = palindrome.charAt(left);

            if (c != 'a') {
                StringBuilder sb = new StringBuilder(palindrome);
                sb.setCharAt(left, 'a');
                return sb.toString();
            } else {
                left++;
                right--;
            }

        }

        // aaaa
        StringBuilder sb = new StringBuilder(palindrome.substring(0, palindrome.length() - 1));
        sb.append('b');
        return sb.toString();

    }
}
```