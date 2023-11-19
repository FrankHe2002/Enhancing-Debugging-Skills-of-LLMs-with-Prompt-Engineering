class Solution {
    public int minSwapsCouples(int[] row) {
        Map<Integer, Integer> parents = new HashMap<>();
        int count = 0;
        for (int i = 0; i < row.length; i += 2) {
            int parent = Math.min(row[i], row[i + 1]);
            int child = Math.max(row[i], row[i + 1]);
            parents.put(parent, child);
        }
        for (int i = 0; i < row.length; i += 2) {
            if ((parents.containsKey(i) && parents.get(i) == (i + 1))
                    || (parents.containsKey(i - 1) && parents.get(i - 1) == i))
                continue;
            count += 1;
            int curChild = parents.get(i);
            int correctChildsChild = parents.get(i + 1);
            parents.remove(i + 1);
            parents.put(Math.min(curChild, correctChildsChild), Math.max(curChild, correctChildsChild));
            parents.put(i, i + 1);
        }
        return count;
    }
}
