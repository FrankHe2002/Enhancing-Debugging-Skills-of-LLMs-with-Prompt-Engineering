class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        int time = 0;
        for (int[] course : courses) {
            time += course[0];
            pq.add(course[0]);
            if (time > course[1]) {
                time -= pq.poll();
            }
        }
        return pq.size();
    }
}