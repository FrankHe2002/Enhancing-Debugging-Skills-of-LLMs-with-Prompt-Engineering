```java
class Solution {
    public String reorganizeString(String s) {
        StringBuilder ans = new StringBuilder("");
        char[] charArray = new char[s.length()];
        Map<Character, Integer> hashMap = new HashMap<>();
        Queue<CharOccurrence> queue = new PriorityQueue<>((a, b) -> b.occurrence - a.occurrence);

        charArray = s.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            Integer occurrence = hashMap.get(charArray[i]);
            if (occurrence == null)
                hashMap.put(charArray[i], 1);
            else
                hashMap.put(charArray[i], occurrence + 1);
        }
        queue.addAll(hashMap.entrySet()
                .stream()
                .parallel()
                .map(e -> new CharOccurrence(e.getKey(), e.getValue()))
                .collect(Collectors.toList()));
        while (! queue.isEmpty()) {
            Queue<CharOccurrence> tmpQueue = new LinkedList<>();
            int sizeQueue = queue.size();
            int stringLength = ans.length();
            int startSub = (stringLength - 1 < 0) ? 0 : stringLength - 1;
            int endSub = stringLength;
            String lastLetter = ans.substring(startSub, endSub);
            boolean letterAdded = false;
            for (int i = 0; i < sizeQueue; i++) {
                CharOccurrence letter = queue.poll();
                if (! lastLetter.contains(String.valueOf(letter.letter))) {
                    letter.occurrence--;
                    ans.append(String.valueOf(letter.letter));
                    if (letter.occurrence > 0)
                        tmpQueue.add(letter);
                    letterAdded = true;
                    break;
                } else {
                    tmpQueue.add(letter);
                }
            }
            if (! letterAdded)
                return "";
            queue.addAll(tmpQueue);
        }
        return ans.toString();

    }

    class CharOccurrence {
        public Character letter;
        public int occurrence;

        public CharOccurrence(Character letter, int occurrence) {
            this.letter = letter;
            this.occurrence = occurrence;
        }
    }
}
```