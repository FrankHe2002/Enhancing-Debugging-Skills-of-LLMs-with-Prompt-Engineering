class Fenwick {
    public int[] tree;

    public Fenwick(int length) {
        tree = new int[length + 1];
    }

    public int sum(int i) {
        int sum = 0;
        while (i > 0) {
            sum += tree[i];
            i -= (i & - i);
        }
        return sum;
    }

    public int sumRange(int start, int end) {
        return sum(end) - sum(start - 1);
    }

    public void update(int i, int k) {
        while (i < tree.length) {
            tree[i] += k;
            i += (i & - i);
        }
    }
}

class Solution {
    public int createSortedArray(int[] instructions) {
        if (instructions.length == 0) {
            return 0;
        }
        int max = 0;
        for (int value : instructions) {
            if (value > max) {
                max = value;
            }
        }
        Fenwick tree = new Fenwick(max + 1);
        int cost = 0;

        for (int i = 0; i < instructions.length; i++) {
            int current_value = instructions[i];
            int strictly_less = tree.sumRange(0, current_value - 1);
            int strictly_greater = tree.sumRange(current_value + 1, max);
            