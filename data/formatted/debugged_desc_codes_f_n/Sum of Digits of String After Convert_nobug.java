```java
class Solution {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++)
            sb.append((s.charAt(i) - 'a') + 1);
        String result = sb.toString();

        int sum;
        for (int j = 0; j < k; j++) {
            sum = 0;
            for (char c : result.toCharArray()) {
                sum += c - '0';
            }
            result = String.valueOf(sum);
        }

        return sum;
    }
}
```