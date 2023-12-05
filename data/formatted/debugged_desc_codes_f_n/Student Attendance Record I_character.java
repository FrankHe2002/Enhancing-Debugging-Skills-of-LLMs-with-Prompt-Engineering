Fix:
```java
class Solution {
    public boolean checkRecord(String s) {

        return (s.replace("A", "").length() <= s.length() - 2) && (s.indexOf("LLL") == -1);

    }
}
```