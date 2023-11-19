class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        List<int[]> list = new ArrayList<>();
        list.add(new int[] {1, 0});
        for (int[] restriction : restrictions) {
            list.add(restriction);
        }
        Collections.sort(list, new IDSorter());

        if (list.get(list.size() - 1)[0] != n) {
            list.add(new int[] {n, n - 1});
        }

        for (int i = 1; i < list.size(); i++) {
            list.get(i)[i] = Math.min(list.get(i)[1], list.get(i - 1)[1] + list.get(i)[0] - list.get(i - 1)[0]);
        }

        for (int i = list.size() - 2; i >= 0; i--) {
            list.get(i)[1] = Math.min(list.get(i)[1], list.get(i + 1)[1] + list.get(i + 1)[0] - list.get(i)[0]);
        }

        int result = 0;
        for (int i = 1; i < list.size(); i++) {
            int h1 = list.get(i - 1)[1];
            int h2 = list.get(i)[1];
            int x = list.get(i - 1)[0];
            int y = list.get(i)[0];

            result = Math.max(result, Math.max(h1, h2) + (y - x - Math.abs(h1 - h2)) / 2);
        }
        return result;
    }

    public class IDSorter implements Comparator<int[]> {
        @Override
        public int compare(int[] myself, int[] other) {
            return myself[0] - other[0];
        }
    }
}