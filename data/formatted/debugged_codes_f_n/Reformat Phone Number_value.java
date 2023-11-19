```java
// Runtime: 1 ms (Top 99.98%) | Memory: 39.6 MB (Top 80.44%)
class Solution {
    String modifiedNumber = "";

    public String reformatNumber(String number) {
        modifiedNumber = number.replace(" ", "");
        modifiedNumber = modifiedNumber.replace("-", "");
        int l = modifiedNumber.length();
        if (l <= 3) {
            return modifiedNumber;
        } else if (l == 4) {
            return modifiedNumber.substring(0, 2) + "-" + modifiedNumber.substring(2, 4);
        } else {
            modifiedNumber = modifiedNumber.substring(0, 3) + "-" + reformatNumber(modifiedNumber.substring(3, l));
        }
        return modifiedNumber;
    }
}
```