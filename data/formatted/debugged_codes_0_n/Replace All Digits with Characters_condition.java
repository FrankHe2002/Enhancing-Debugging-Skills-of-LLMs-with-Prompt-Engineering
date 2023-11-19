```java
// Runtime: 2 ms (Top 43.86%) | Memory: 42.6 MB (Top 27.39%)
class Solution {
    public String replaceDigits(String s) {
        char[] str = s.toCharArray();

        for (int i = 1; i < str.length; i += 2) {
            if (Character.isDigit(str[i])) {
                str[i] = shift(str[i - 1], str[i]);
            }
        }
        return String.valueOf(str);
    }

    char shift(char letter, char number) {
        int a = Character.getNumericValue(number);
        int asci = (int) letter;
        char c = (char) (asci + a);
        return c;
    }
}
```