```java
class Solution {
    public boolean areNumbersAscending(String s) {
        int prev = 0;

        for (String token : s.split(" ")) {
            if (Character.isDigit(token.charAt(0))) {
                int number = Integer.parseInt(token);
                if (number <= prev)
                    return false;
                prev = number;
            }
        }
        return true;
    }
}
```