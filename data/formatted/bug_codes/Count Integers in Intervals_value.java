class CountIntervals {

    TreeMap<Integer, Integer> map = new TreeMap<>();
    int count = 0;

    public CountIntervals() {
    }

    public void add(int left, int right) {
        int add = right - left + 1;
        var left_bound = map.lowerEntry(left + 1);
        if (left_bound != null && left_bound.getValue() >= left) {
            left = left_bound.getKey();
            right = Math.max(left_bound.getValue(), right);
            add = right - left_bound.getValue();
            map.remove(left_bound.getKey());
        }
        for (var i = map.higherEntry(left); i != null && i.getKey() <= right; i = map.higherEntry(left)) {
            add -= Math.min(right, i.getValue()) - i.getKey() + 1;
            right = Math.max(right, i.getValue());
            map.remove(i.getKey());
        }
        map.put(left, right);
        count += add;


    }

    public int count() {
        return count;
    }
}

