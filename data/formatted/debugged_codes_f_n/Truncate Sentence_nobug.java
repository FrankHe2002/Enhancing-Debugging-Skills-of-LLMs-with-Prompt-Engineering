# Buggy Code:
```java
class Solution {
    public String truncateSentence(String s, int k) {
        int n = s.length();
        int count = 0;
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') {
                count++;
                if (count == k)
                    return s.substring(0, i);
            }
            i++;
        }
        return s;
    }
}
```

# Fixed Code:
```java
class Solution {
    public String truncateSentence(String s, int k) {
        int n = s.length();
        int count = 0;
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') {
                count++;
                if (count == k)
                    return s.substring(0, i);
            }
            i++;
        }
        return s.substring(0, n);
    }
}
```