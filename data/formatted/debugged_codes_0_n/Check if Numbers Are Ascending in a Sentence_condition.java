```java
class Solution {
    public boolean areNumbersAscending(String s) {
        int prev = -1; // Change initial value of prev to -1

        for (String token : s.split(" ")) {
            try {
                int number = Integer.parseInt(token);
                if (number <= prev) // Change "<" to "<="
                    return false;
                prev = number;
            } catch (Exception e) {
            }
        }

        return true;
    }
}
```