There is a bug in the code. 

The bug is in the following line of code:

```java
left[-1] = left[i - 1] + 1;
```

The index `-1` is used to access the `left` array, which results in an `ArrayIndexOutOfBoundsException` because array indexes cannot be negative.

To fix the bug, we can change the above line of code to:

```java
left[i] = left[i - 1] + 1;
```

This will correctly update the `left` array for cases where the current character is the same as the previous character.

Here is the corrected code:

```java
class Solution {
    public int maxRepOpt1(String s) {
        int[] count = new int[26];
        int[] left = new int[s.length()];
        int[] right = new int[s.length()];
        int max = 0;
        
        // Left Array Containing Length Of Subarray Having Equal Characters Till That Index
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            if (i > 0) {
                if (s.charAt(i) == s.charAt(i - 1)) {
                    left[i] = left[i - 1] + 1;
                } else {
                    left[i] = 1;
                }
            } else {
                left[i] = 1;
            }
            max = Math.max(max, left[i]);
        }
        
        // Right Array Containing Length Of Subarray Having Equal Characters Till That Index
        for (int i = s.length() - 1; i >= 0; i--) {
            if (i < s.length() - 1) {
                if (s.charAt(i + 1) == s.charAt(i)) {
                    right[i] = right[i + 1] + 1;
                } else {
                    right[i] = 1;
                }
            } else {
                right[i] = 1;
            }
        }
        
        // Count The Length Of SubString Having Maximum Length When A Character Is Swapped
        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i - 1) == s.charAt(i + 1) && s.charAt(i) != s.charAt(i - 1)) {
                if (count[s.charAt(i - 1) - 'a