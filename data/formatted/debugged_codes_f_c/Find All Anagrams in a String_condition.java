Bug Type: Logic Error

Reasoning:
The `findAnagrams` method is intended to find all anagrams of string `p` in string `s`. However, the implementation has several issues. 

First, the `currentAnagramMap` is incorrectly being reset to a new empty map (`currentAnagramMap = new HashMap<>();`) when a character in `s` is not found in `p`. This reset operation should not be performed because it discards the progress made in finding an anagram and restarts the search from scratch. To fix this error, the code to reset `currentAnagramMap` and related variables should be removed.

Second, the code for handling when `currentAnagramMap.get(c) > anagramMap.get(c)` is flawed. It incorrectly assumes that the leftmost character to the right of `left` is always equal to `c`, which may not be true. Additionally, it does not properly handle the case when the count of a character in `currentAnagramMap` becomes equal to the count in `anagramMap`. To fix this, the loop where `leftC` is compared to `c` should be modified to check if `currentAnagramMap.get(leftC)` is greater than `anagramMap.get(leftC)`.

Third, the code does not reset `currentMatchCount` when a character in `s` is not found in `p`. This causes incorrect counting of the match count. To fix this, `currentMatchCount` should be reset to 0 when a character in `s` is not found in `p`. 

Fixed Code:

```java
class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        int fullMatchCount = p.length();
        Map<Character, Integer> anagramMap = new HashMap<>();

        for (Character c : p.toCharArray())
            anagramMap.put(c, anagramMap.getOrDefault(c, 0) + 1);

        List<Integer> result = new ArrayList<>();
        int left = 0, right = 0, currentMatchCount = 0;
        Map<Character, Integer> currentAnagramMap = new HashMap<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            if (anagramMap.get(c) == null) {
                currentAnagramMap.clear();
                right++;
                left = right;
                currentMatchCount = 0;
                continue;
            }
            currentAnagramMap.put(c