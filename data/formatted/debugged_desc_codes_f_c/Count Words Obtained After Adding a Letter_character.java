```java
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        Set<String> set = new HashSet<>();

        for (String start : startWords) {
            char[] sAr = start.toCharArray();
            Arrays.sort(sAr);
            set.add(new String(sAr));
        }

        int count = 0;
        for (String target : targetWords) {
            char[] tAr = target.toCharArray();
            Arrays.sort(tAr);
            String s = new String(tAr);

            boolean found = false;
            for (int j = 0; j < s.length(); j++) {
                String str = s.substring(0, j) + s.substring(j + 1);
                if (set.contains(str)) {
                    found = true;
                    break;
                }
            }
            if (found) {
                count++;
            }
        }
        return count;
    }
}
```