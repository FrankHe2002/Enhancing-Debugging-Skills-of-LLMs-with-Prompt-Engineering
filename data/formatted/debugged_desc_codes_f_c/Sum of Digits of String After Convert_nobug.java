```java
class Solution {
    public int getLucky(String s, int k) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++)
            sb.append((s.charAt(i) - 'a' + 1));
        String result = sb.toString();

        int sum = 0;
        while (k-- > 0) {
            sum = 0;
            for (int i = 0; i < result.length(); i++)
                sum += result.charAt(i) - '0';

            result = String.valueOf(sum);
        }

        return sum;
    }
}
```