The bug in the code is in the for loop where the words array is being accessed at index i + 2. This is causing an IndexOutOfBoundsException because it is trying to access an index that is out of bounds.

To fix this bug, we need to access the words array at index i instead of i + 2.

Here's the corrected code:

```java
import java.util.HashMap;

class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        HashMap<String, Integer> hm = new HashMap<>();

        int max = 0;
        String name = "";
        for (int i = 0; i < messages.length; i++) {
            String[] words = messages[i].split(" ");

            int freq = hm.getOrDefault(senders[i], 0) + words.length;
            hm.put(senders[i], freq);

            if (hm.get(senders[i]) > max) {
                max = hm.get(senders[i]);
                name = senders[i];
            } else if (hm.get(senders[i]) == max && name.compareTo(senders[i]) < 0) {
                name = senders[i];
            }
        }

        return name;
    }
}
```