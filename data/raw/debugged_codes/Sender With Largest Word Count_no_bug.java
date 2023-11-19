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

            int currentFreq = hm.get(senders[i]);
            if (currentFreq > max) {
                max = currentFreq;
                name = senders[i];
            } else if (currentFreq == max && name.compareTo(senders[i]) < 0) {
                name = senders[i];
            }
        }

        return name;
    }
}