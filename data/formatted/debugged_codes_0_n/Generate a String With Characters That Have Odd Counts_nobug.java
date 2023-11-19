```java
class Solution {
    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        String string = "a";
        for (int i = 0; i < n - 1; i++)
            sb.append(string);
        if (n % 2 == 0)
            return sb.toString() + "b";
        return sb.toString() + "a";
    }
}
```