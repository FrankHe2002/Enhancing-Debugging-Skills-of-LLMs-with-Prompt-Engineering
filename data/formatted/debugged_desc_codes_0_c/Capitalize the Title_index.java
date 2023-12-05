The bug in the given code is due to a typo in the while loop condition. The condition `ch[MB] != ' '` should be `ch[i] != ' '`. This typo is causing an error when checking for the end of the word.

Here's the corrected code:

```java
class Solution {
    public String capitalizeTitle(String title) {
        char[] ch = title.toCharArray();
        int len = ch.length;

        for (int i = 0; i < len; ++i) {
            int firstIndex = i; // store the first index of the word
          
            while (i < len && ch[i] != ' ') {
                ch[i] = Character.toLowerCase(ch[i]); // converting the character at ith index to lower case ony by one
                ++i;
            }

            // if word is of length greater than 2, then turn the first character of the word to upper case
            if (i - firstIndex > 2) {
                ch[firstIndex] = Character.toUpperCase(ch[firstIndex]); // converting the first character of the word to upper case
            }
        }

        return new String(ch); // return the final result by converting the char array into string
    }
}
```

I have corrected the typo in the while loop condition, and I have also used `new String(ch)` instead of `String.valueOf(ch)` to create a String from the char array, as it is more conventional.