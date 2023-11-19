The bug in the provided code is a compilation error due to undeclared variables (`temp2` and `temp3`). To fix this error, we need to declare `temp2` and `temp3` as strings.

Fixed Code:

```java
class Solution {
    public String gcdOfStrings(String str1, String str2) {

        int length1 = str1.length();
        int length2 = str2.length();
        String temp, temp2, temp3;

        for (int i = gcd(length1, length2); i > 0 && length1 % i == 0 && length2 % i == 0; i--) {
            if (str1.substring(0, i).equals(str2.substring(0, i))) {
                if (doesRepeat(str1.substring(0, i), str1, str2))
                    return str1.substring(0, i);
            }
        }
        return "";

    }

    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public boolean doesRepeat(String s, String str1, String str2) {
        int sLength = s.length();
        boolean bool1 = true, bool2 = true;
        String temp = str1, temp2;

        while (sLength < temp.length()) {
            temp2 = temp.substring(sLength, sLength * 2);

            if (s.equals(temp2)) ;
            else
                bool1 = false;
            temp = temp.substring(sLength, temp.length());
        }
        temp = str2;
        while (sLength < temp.length()) {
            temp2 = temp.substring(sLength, sLength * 2);
            if (s.equals(temp2)) ;
            else
                bool2 = false;
            temp = temp.substring(sLength, temp.length());
        }
        return bool1 && bool2;
    }
}
```