The bug type is a logical error in the for loop of the second sentence. 

Here is the revised code:

```java
import java.util.*;

class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        List<String> list = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        String[] arr1 = s1.split(" ");
        String[] arr2 = s2.split(" ");
        for (String word : arr1) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (String word : arr2) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                list.add(entry.getKey());
            }
        }
        String[] res = new String[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
```