class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int overlap = 0;
        List<Double> list = new ArrayList<>(points.size());
        for (List<Integer> p : points) {
            if (p.get(0) == location.get(0) && p.get(1) == location.get(1)) {
                overlap++;
            } else {
                list.add(angle(p.get(1) - location.get(1),
                        p.get(0) - location.get(0)));
            }
        }
        Collections.sort(list);
        int max = 0;
        int n = list.size();
        int i2 = 0;
        for (int i1 = 0; i1 < n; i1++) {
            while ((i2 < n && list.get(i2) - list.get(i1) <= angle) ||
                    (i2 >= n && 360 + list.get(i2 % n) - list.get(i1) <= angle)) {
                i2++;
            }
            max = Math.max(max, i2 - i1);
        }
        return max + overlap;
    }

    private double angle(int dy, int dx) {
        double a = Math.toDegrees(Math.atan2(dy, dx));
        return (a < 0 ? a + 360 : a);
    }
}