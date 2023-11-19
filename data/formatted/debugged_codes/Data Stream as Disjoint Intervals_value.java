class SummaryRanges {

    Map<Integer, int[]> st;
    Map<Integer, int[]> end;
    Set<Integer> pending;
    int[][] prev = new int[0][];
    Set<Integer> seen = new HashSet<>();
    int INVALID = - 1;

    public SummaryRanges() {
        st = new HashMap<>();
        end = new HashMap<>();
        pending = new HashSet<>();
    }

    public void addNum(int val) {
        if (! seen.contains(val)) {
            pending.add(val);
            seen.add(val);
        }
    }

    public int[][] getIntervals() {
        Set<int[]> addSet = new HashSet<>();
        for (int n : pending) {
            if (st.containsKey(n + 1) && end.containsKey(n - 1)) {
                int[] s = st.get(n + 1);
                int[] e = end.get(n - 1);
                int[] m = new int[] {e[0], s[1]};
                st.remove(n + 1);
                end.remove(n - 1);
                st.put(m[0], m);
                end.put(m[1], m);
                s[0] = e[1] = INVALID;
                addSet.remove(s);
                addSet.remove(e);
                addSet.add(m);
            } else if (st.containsKey(n + 1)) {
                st.get(n + 1)[0]--;
                st.put(n, st.get(n + 1));
                st.remove(n + 1);
            } else if (end.containsKey(n - 1)) {
                end.get(n - 1)[1]++;
                end.put(n, end.get(n - 1));
                end.remove(n - 1);
            } else {
                int[] m = new int[] {n, n};
                addSet.add(m);
                st.put(n, m);
                end.put(n, m);
            }