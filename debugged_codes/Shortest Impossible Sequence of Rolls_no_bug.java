class Solution {
    public int shortestSequence(int[] rolls, int k) {
        int len = 0;
        Set<Integer> set = new HashSet<>();
        for (int i : rolls) {
            set.add(i);
            if (set.size() == k) {
                set.clear();
                len++;
            }
        }
        return len + 1;
    }
}