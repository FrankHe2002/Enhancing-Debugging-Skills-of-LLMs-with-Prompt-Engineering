```java
class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int evenNo = 0;
        int oddNo = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }

        }
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            int n = e.getValue();
            if (n % 2 != 0) {
                oddNo += 1;
            }
            evenNo += (n / 2) * 2;
        }

// You should check whether there is any occurrence of an odd number of characters in the string
        if (oddNo > 0) {
            evenNo += 1;
        }
        return evenNo;
    }
}
```