```java
// Runtime: 0 ms (Top 100.0%) | Memory: 40.99 MB (Top 67.1%)

import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<String> removeComments(String[] source) {
        boolean blockActive = false;

        List<String> result = new ArrayList<String>();
        StringBuilder builder = new StringBuilder();

        for (String line : source) {
            if (! blockActive) {
                builder = new StringBuilder();
            }
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if (! blockActive) {
                    if (c == '/') {
                        if (i < line.length() - 1 && line.charAt(i + 1) == '/') {
                            break;
                        } else if (i < line.length() - 1 && line.charAt(i + 1) == '*') {
                            i++;
                            blockActive = true;
                        } else {
                            builder.append(c);
                        }
                    } else {
                        builder.append(c);
                    }
                } else {
                    if (c == '*') {
                        if (i < line.length() - 1 && line.charAt(i + 1) == '/') {
                            blockActive = false;
                            i++;
                        }
                    }
                }
            }
            if (! blockActive && builder.length() != 0) {
                result.add(builder.toString());
            }
        }
        return result;
    }
}
```