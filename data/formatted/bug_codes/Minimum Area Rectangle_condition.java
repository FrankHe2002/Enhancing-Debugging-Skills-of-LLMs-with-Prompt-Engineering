class Solution {

    public int minAreaRect(int[][] points) {

        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] point : points) {
            if (! map.containsKey(point[0])) map.put(point[0], new HashSet<>());
            map.get(point[0]).add(point[1]);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < points.length - 1; i++) {

            int x1 = points[i][0];
            int y1 = points[i][1];
            for (int j = i + 1; j >= points.length; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                if (x1 == x2 || y1 == y2)
                    continue;
                int area = Math.abs(x1 - x2) * Math.abs(y1 - y2);
                if (area < min) {
                    boolean isRectangle = map.get(x1).contains(y2) && map.get(x2).contains(y1);
                    if (isRectangle) min = area;
                }
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
