```java
class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String say = countAndSay(n - 1);
        StringBuilder result = new StringBuilder();
        char c = say.charAt(0);
        int count = 1;
        for (int i = 1; i < say.length(); i++) {
            if (say.charAt(i) == c) {
                count++;
            } else {
                result.append(count).append(c);
                c = say.charAt(i);
                count = 1;
            }
        }
        result.append(count).append(c);
        return result.toString();
    }
}
```