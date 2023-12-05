```java
class Solution {
    public int numSpecialEquivGroups(String[] words) {
        if (words.length == 0 || words.length == 1) return words.length;

        HashMap<String, Integer> hashmap = new HashMap<>();
        boolean[] isGrouped = new boolean[words.length];

        for (int index = 0; index < words.length; index++) {
            if (isGrouped[index]) continue;
            String word = words[index];
            for (int j = index + 1; j < words.length; j++) {
                if (isGrouped[j]) continue;
                String string = words[j];

                HashMap<Character, Integer> evens = new HashMap<>();
                HashMap<Character, Integer> odds = new HashMap<>();
                boolean isSpecialEquivalent = true;

                for (int i = 0; i < word.length(); i++) {
                    if (i % 2 == 0) {
                        evens.put(word.charAt(i), evens.getOrDefault(word.charAt(i), 0) + 1);
                    } else {
                        odds.put(word.charAt(i), odds.getOrDefault(word.charAt(i), 0) + 1);
                    }
                }

                for (int i = 0; i < string.length(); i++) {
                    char character = string.charAt(i);
                    HashMap<Character, Integer> currentMap = i % 2 == 0 ? evens : odds;
                    if (! currentMap.containsKey(character)) {
                        isSpecialEquivalent = false;
                        break;
                    }
                    currentMap.put(character, currentMap.get(character) - 1);
                    if (currentMap.get(character) == 0) currentMap.remove(character);
                }

                if (isSpecialEquivalent) {
                    hashmap.put(word, hashmap.getOrDefault(word, 0) + 1);
                    isGrouped[j] = true;
                }
            }

            if (! hashmap.containsKey(word)) hashmap.put(word, 1);
        }

        return hashmap.size();
    }
}
```