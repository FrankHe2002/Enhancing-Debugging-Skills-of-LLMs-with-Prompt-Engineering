### Fixed Java Code
```java
import java.util.HashMap;

class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        HashMap<String, Integer> hm = new HashMap<>();

        int max = 0;
        String name = "";
        for (int i = 0; i < messages.length; i++) {
            String[] words = messages[i].split(" ");  // modify from messages[i + 2] to messages[i]

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