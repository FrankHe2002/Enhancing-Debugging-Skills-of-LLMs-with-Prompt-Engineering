class Solution {
    public int countPoints(String rings) {
        Map<Character, Set<Integer>> m = new HashMap<>();
        for (int i = 0; i < rings.length(); i = i + 2) {
            char c = rings.charAt(i);
            int index = (int) rings.charAt(i + 1);
            if (m.containsKey(c)) {
                Set<Integer> x = m.get(c);
                x.add(index);
                m.put(c, x);
            } else {
                Set<Integer> x = new HashSet<>();
                x.add(index);
                m.put(c, x);
            }
        }
        int count = 0;
        for (Set<Integer> k : m.values()) {
            if (k.size() == 3) count++;
        }
        return count;
    }
}