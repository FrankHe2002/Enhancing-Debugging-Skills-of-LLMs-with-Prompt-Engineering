class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> lr = new ArrayList<>();
        HashMap<Character, Integer> lastIndexMap = new HashMap<>();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            lastIndexMap.put(s.charAt(i), i);
        }

        for (int i = 0; i < s.length(); i++) {
            int lastIndex = lastIndexMap.get(s.charAt(i));
            while (i <= lastIndex) {
                lastIndex = Math.max(lastIndex, lastIndexMap.get(s.charAt(i)));
                i++;
                count++;
            }
            lr.add(count);
            count = 0;
            i--;
        }

        return lr;
    }
}