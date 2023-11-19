```java
// Runtime: 11 ms (Top 15.1%) | Memory: 43.1 MB (Top 17.4%)
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int maximumNumberOfStringPairs(String[] words) {
        ArrayList<String> obj = new ArrayList<String>();
        Collections.addAll(obj, words);
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            String str = words[i];
            int n = str.length();
            String ktr = "";
            //REVERSE
            for (int k = 0; k < n; k++) {
                ktr = str.charAt(k) + ktr;
            }
            //REMOVE ELEMENTS LIKE "ZZ","aa"
            if (i < obj.size() && obj.get(i).equals(ktr)) {
                obj.remove(i);
            }
            //REMOVE ELEMENTS IF PRESENT IN ARRAY LIST
            if (obj.contains(ktr)) {
                obj.remove(str);
                count++;
            }
        }
        return count;
    }
}
```