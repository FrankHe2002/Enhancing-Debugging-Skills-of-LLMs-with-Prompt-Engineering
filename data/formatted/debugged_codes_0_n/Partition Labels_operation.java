```java
class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> lr = new ArrayList<>();
        HashMap<Character, Integer> mp = new HashMap<>();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            mp.put(s.charAt(i), i);
        }

        int maxIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            maxIndex = Math.max(maxIndex, mp.get(s.charAt(i)));
            if (i == maxIndex) {
                lr.add(count + 1);
                count = 0;
            } else {
                count++;
            }
        }

        return lr;
    }
}
```