class RangeModule {
    TreeMap<Integer, Integer> map;

    public RangeModule() {
        map = new TreeMap<>();
    }

    public void addRange(int left, int right) {
        Integer l1 = map.floorKey(left);
        Integer l2 = map.floorKey(right);

        if (l1 == null && l2 == null) {
            map.put(left, right);
        } else if (l1 != null && map.get(l1) >= left) {
            map.put(l1, Math.max(right, map.get(l2)));
        } else {
            map.put(left, Math.max(right, map.get(l2)));
        }

        map.subMap(left, false, right, true).clear();
    }

    public boolean queryRange(int left, int right) {
        Integer l = map.floorKey(left);
        if (l != null && map.get(l) >= right) {
            return true;
        }
        return false;
    }

    public void removeRange(int left, int right) {
        Integer l1 = map.lowerKey(left);
        Integer l2 = map.lowerKey(right);

        if (l2 != null && map.get(l2) > right) {
            map.put(right, map.get(l2));
        }

        if (l1 != null && map.get(l1) > left) {
            map.put(l1, left);
        }

        map.subMap(left, true, right, false).clear();
    }
}