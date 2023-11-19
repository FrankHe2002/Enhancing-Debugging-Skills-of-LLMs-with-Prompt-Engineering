```java
class Solution {
    //class for segments 
    class Seg {
        int val, end;
        int color;
        boolean isStart;

        public Seg(int val, int end, int color, boolean isStart) {
            this.val = val;
            this.end = end;
            this.color = color;
            this.isStart = isStart;
        }

        public String toString() {
            return "[" + val + " " + end + " " + color + " " + isStart + "]";
        }
    }

    public List<List<Long>> splitPainting(int[][] segments) {
        List<List<Long>> res = new ArrayList<>();

        List<Seg> list = new ArrayList<>();

        //making a list of segments
        for (int[] segment : segments) {
            list.add(new Seg(segment[0], segment[1], segment[2], true));
            list.add(new Seg(segment[1], segment[1], segment[2], false));
        }

        //Sorting the segments
        Collections.sort(list, (a, b) -> {
            return a.val - b.val;
        });

        //System.out.println(list);

        //Iterating over list to combine the elements
        for (Seg curr : list) {
            int len = res.size();
            if (curr.isStart) {
                //if the segment is starting there could be three ways 
                if (res.size() > 0 && res.get(len - 1).get(0) == curr.val) {
                    //if starting point of two things is same
                    List<Long> temp = res.get(len - 1);
                    temp.set(1, Math.max(temp.get(1), curr.end));
                    temp.set(2, (long) (temp.get(2) + curr.color));
                } else if (res.size() > 0 && res.get(len - 1).get(1) > curr.val) {
                    //if there is a start in between create a new segment of different color 
                    List<Long> prev = res.get(len - 1);
                    prev.set(1, (long) curr.val);
                    List<Long> temp = new ArrayList<>();
                    temp.add((long) curr.val);
                    temp.add((long) curr.end);
                    temp.add((long) (prev.get(2) + curr.color));
                    res.add(temp);
                } else {
                    //Add a new value if nothing is present in result
                    List<Long> temp = new ArrayList