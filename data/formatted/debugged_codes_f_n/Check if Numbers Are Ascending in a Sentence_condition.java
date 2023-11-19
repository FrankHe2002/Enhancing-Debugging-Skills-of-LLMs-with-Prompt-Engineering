Fixed Code:
```java
class Solution {
    public boolean areNumbersAscending(String s) {
        int prev = -1; // fix: set prev to -1 instead of 0

        for (String token : s.split(" ")) {
            try {
                int number = Integer.parseInt(token);
                if (number <= prev) // fix: change < to <=
                    return false;
                prev = number;
            } catch (Exception e) {
            }
        }

        return true;
    }
}
```