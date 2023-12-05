```java
class Solution {
    public int numSub(String s) {
        char[] ch = s.toCharArray();
        long count = 0;
        long result = 0;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '1') {
                count++;
            } else {
                result += (count * (count + 1) / 2) % 1000000007;
                count = 0;
            }
        }
        result += (count * (count + 1) / 2) % 1000000007;
        return (int) (result % 1000000007);
    }
}
```