```java
class Solution {
    public String digitSum(String s, int k) {
        while (s.length() < k) s = gen(s, k);
        return s;
    }

    public String gen(String s, int k) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int count = 0, num = 0;
            while (i < s.length() && count++ < k) num += Character.getNumericValue(s.charAt(i++));
            res.append(num);
        }
        return res.toString();
    }
}
```