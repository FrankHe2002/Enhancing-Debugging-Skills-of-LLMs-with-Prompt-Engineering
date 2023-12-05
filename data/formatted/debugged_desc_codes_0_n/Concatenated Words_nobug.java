```java
class Solution {
    Set<String> set = new HashSet<>();
    Set<String> res = new HashSet<>();
    int index = 0;

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        for (String word : words) set.add(word);
        for (String word : words) {
            int len = word.length();
            index = 0;
            if (backtrack(len, word, 0)) {
                res.add(word);
            }
        }
        List<String> list = new ArrayList<>(res);
        return list;
    }

    public boolean backtrack(int len, String word, int num) {
        if (index == len && num >= 2) {
            return true;
        }
        int indexCopy = index;
        for (int i = index + 1; i <= len; i++) {
            if (set.contains(word.substring(index, i))) {
                index = i;
                if (backtrack(len, word, num + 1)) {
                    return true;
                }
                index = indexCopy;
            }
        }
        return false;
    }
}
```