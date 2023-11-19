```java
class Solution {
    public String longestNiceSubstring(String s) {
        String result = "";
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String temp = s.substring(i, j);
                if (temp.length() > 1 && result.length() < temp.length() && checkNice(temp)) {
                    result = temp;
                }
            }
        }
        return result;
    }

    public boolean checkNice(String temp) {
        Set<Character> set = new HashSet<>();
        for (char ch : temp.toCharArray()) {
            set.add(ch);
        }
        for (char ch : set) {
            if (set.contains(Character.toUpperCase(ch)) != set.contains(Character.toLowerCase(ch))) {
                return false;
            }
        }
        return true;
    }
}
```