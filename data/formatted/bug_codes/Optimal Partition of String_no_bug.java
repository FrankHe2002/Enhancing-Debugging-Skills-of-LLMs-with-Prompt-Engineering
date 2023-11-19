class Solution {
    public int partitionString(String s) {
        int idx = 0;
        int count = 0;
        Map<Character, Boolean> mp = new HashMap<>();
        while (idx < s.length()) {
            if (mp.containsKey(s.charAt(idx))) {
                count++;
                mp.clear();
            }
            mp.put(s.charAt(idx), true);
            idx++;
        }
        return count + 1;
    }
}