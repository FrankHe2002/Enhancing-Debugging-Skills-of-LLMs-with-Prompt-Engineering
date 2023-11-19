class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i < bound && i != 0; i *= x) {
            for (int j = 1; i + j <= bound && j != 0; j *= y) {
                set.add(i + j);
                if (y == 1) break;
            }
            if (x == 1) break;
        }
        return new ArrayList<>(set);
    }
}