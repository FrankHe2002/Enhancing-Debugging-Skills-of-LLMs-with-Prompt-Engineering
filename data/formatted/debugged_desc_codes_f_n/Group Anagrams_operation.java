Fix:

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> hm = new HashMap<>();
        for (String s : strs) {
            char ch[] = s.toCharArray();
            Arrays.sort(ch);
            StringBuilder sb = new StringBuilder("");
            for (char c : ch) {
                sb.append(c);
            }
            String str = sb.toString();
            if (hm.containsKey(str)) {
                ArrayList<String> temp = hm.get(str);
                temp.add(s);
            } else {
                ArrayList<String> temp = new ArrayList<>();
                temp.add(s);
                hm.put(str, temp);
            }
        }
        return new ArrayList<>(hm.values());
    }
}
```