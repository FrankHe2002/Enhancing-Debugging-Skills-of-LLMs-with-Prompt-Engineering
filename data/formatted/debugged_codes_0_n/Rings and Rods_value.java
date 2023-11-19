```java
class Solution {
    public int countPoints(String rings) {
        Map<Integer, Set<Character>> m = new HashMap<>();
        for (int i = 0; i < rings.length(); i += 4) {
            char c = rings.charAt(i);
            int index = (int) rings.charAt(i + 2) - '0';
            if (m.containsKey(index)) {
                Set<Character> x = m.get(index);
                x.add(c);
                m.put(index, x);
            } else {
                Set<Character> x = new HashSet<>();
                x.add(c);
                m.put(index, x);
            }
        }
        int count = 0;
        for (Set<Character> k : m.values()) {
            if (k.size() == 3) count++;
        }
        return count;
    }
}
```