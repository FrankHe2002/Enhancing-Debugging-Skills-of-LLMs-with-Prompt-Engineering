class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new sortEnvelopes());
        ArrayList<Integer> tempList = new ArrayList<>();
        tempList.add(envelopes[0][1]);

        for (int i = 1; i < envelopes.length; i++) {
            if (envelopes[i][1] > tempList.get(tempList.size() - 1)) {
                tempList.add(envelopes[i][1]);
            } else {
                int index = lowerBound(tempList, envelopes[i][1]);
                tempList.set(index, envelopes[i][1]);
            }
        }
        return tempList.size();
    }

    public int lowerBound(ArrayList<Integer> list, int search) {
        int start = 0;
        int end = list.size() - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (list.get(mid) < search) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}

class sortEnvelopes implements Comparator<int[]> {
    public int compare(int[] a, int[] b) {
        if (a[0] == b[0]) {
            return b[1] - a[1];
        } else {
            return a[0] - b[0];
        }
    }
}
