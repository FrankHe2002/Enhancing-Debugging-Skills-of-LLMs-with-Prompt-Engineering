```java
class Solution {
    public String[] divideString(String s, int k, char fill) {
        int rem = -1;
        if (s.length() % k != 0) {
            rem = k - s.length() % k; //counting the total positions where we have to fill the char "fill".
        }
        for (int i = 0; i < rem; i++) {
            s = s + fill; //appending the char to the String
        }

        String[] strs = new String[(int) Math.ceil((double) s.length() / k)];  //the length will be (String length / K) and the ceiling value because we are making pairs of k length Strings.
        int index = 0;  //index for array.
        for (int i = 0; i < s.length(); i += k) {
            strs[index] = s.substring(i, i + k); //substring from current element to the Kth element.
            index++;
        }
        return strs;
    }
}
```