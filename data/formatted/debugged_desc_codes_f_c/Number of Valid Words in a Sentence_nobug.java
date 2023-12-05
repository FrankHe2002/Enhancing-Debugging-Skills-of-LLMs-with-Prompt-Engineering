Bug Type: Logic Error

Explanation: The current regular expression in the code needs fixing. The regex variable should be updated to match the conditions described for valid words.

Fix:
```java
class Solution {
    public int countValidWords(String sentence) {
        String regex = "^[a-z]+(-[a-z]+)?([!,.])?$";
        String[] arr = sentence.split("\\s+");
        int ans = 0;
        for (String s : arr) {
            if (s.matches(regex)) {
                ans++;
            }
        }
        return ans;
    }
}
```