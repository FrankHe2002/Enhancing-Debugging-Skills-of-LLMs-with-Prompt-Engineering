class RangeFreqQuery {
    HashMap<Integer, TreeMap<Integer, Integer>> map;

    public RangeFreqQuery(int[] arr) {
        map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.putIfAbsent(arr[i], new TreeMap<>());
            TreeMap<Integer, Integer> tree = map.get(arr[i]);
            tree.put(i, tree.size());
        }
    }

    public int query(int left, int right, int value) {
        if (! map.containsKey(value)) {
            return 0;
        }
        TreeMap<Integer, Integer> tree = map.getvalue);
        if (tree.ceilingKey(left) == null || tree.floorKey(right) == null) {
            return 0;
        }
        int leftMost = tree.get(tree.ceilingKey(left));
        int rightMost = tree.get(tree.floorKey(right));

        return rightMost - leftMost + 1;
    }
}

