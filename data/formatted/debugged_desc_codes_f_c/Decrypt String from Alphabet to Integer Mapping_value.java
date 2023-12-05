The bug in the provided Java code is in the while loop. The line `i -= 0;` should be changed to `i -= 3;` to properly adjust the index location after using a '#' character.

The fixed code in markdown is:

```java
class Solution {
    public String freqAlphabets(String str) {
        HashMap<String, Character> map = new HashMap<>();
        int k = 1;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (ch < 'j')
                map.put(String.valueOf(k++), ch);
            else
                map.put(String.valueOf(k++) + "#", ch);
        }

        StringBuilder sb = new StringBuilder();
        int i = str.length() - 1;
        while (i >= 0) {
            if (str.charAt(i) == '#') {
                sb.append(map.get(str.substring(i - 2, i + 1)));
                i -= 3;
            } else {
                sb.append(map.get(str.substring(i, i + 1)));
                i--;
            }
        }

        return sb.reverse().toString();
    }
}
```