Fixed code:
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
            backtrack(len, word, 0, 0);
        }
        List<String> list = new ArrayList<>();
        for (String word : res) list.add(word);
        return list;
    }
  
    public void backtrack(int len, String word, int num, int initial) {
        if ((index == len && num >= 2) && initial != len) {
            res.add(word);
        }
        int indexCopy = index;
        for (int i = index + 1; i <= len; i++) {
            if (set.contains(word.substring(index, i))) {
                index = i;
                if (initial == 0) {
                    initial = index;
                }
                backtrack(len, word, num + 1, initial);
                index = indexCopy;
            }
        }
        return;
    }
}

```