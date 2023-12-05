```java
class Solution {
    public String gcdOfStrings(String str1, String str2) {

        int length1 = str1.length();
        int length2 = str2.length();
        String temp;
        int gCDD = gcd(length1, length2);

        for (int i = gCDD; i > 0 && length1 % i == 0 && length2 % i == 0; i--) {
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
        String temp = str1, temp2, temp3;

        while (sLength < temp.length()) {
            temp2 = temp.substring(0, sLength);
            temp3 = temp.substring(sLength, sLength * 2);

            if (s.equals(temp2)) {
                temp = temp.substring(sLength);
            } else if (s.equals(temp3)) {
                temp = temp.substring(sLength, temp.length());
            } else {
                bool1 = false;
                break;
            }
        }
        temp = str2;
      
        while (sLength < temp.length()) {
            temp2 = temp.substring(0, sLength);
            temp3 = temp.substring(sLength, sLength * 2);
           
            if (s.equals(temp2)) {
                temp = temp.substring(sLength);
            } else if (s.equals(temp3)) {
                temp = temp.substring(sLength, temp.length());
            } else {
                bool2 = false;
                break;
            }
        }
        return bool1 && bool2;
    }

}
```