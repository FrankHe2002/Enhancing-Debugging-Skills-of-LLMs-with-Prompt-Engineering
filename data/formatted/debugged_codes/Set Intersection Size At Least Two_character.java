class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[1] == b[1]) {
                    return b[0] - a[0];
                }
                return a[1] - b[1];
            }
        });
        List<Integer> list = new ArrayList<>();
        list.add(intervals[0][1] - 1);
        list.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            int lastOne = list.get(list.size() - 1);
            int lastTwo = list.get(list.size() - 2);

            int[] interval = intervals[i];
            int start = interval[0];
            int end = interval[1];
            if (lastOne >= start && lastTwo >= start) {
                continue;
            } else if (lastOne >= start) {
                list.add(end);
            } else {
                list.add(end - 1);
                list.add(end);
            }
        }

        return list.size();
    }
}