class Solution {
    private final int M, N, CAPACITY;
    private int size;
    private Random random;
    private Map<Integer, Integer> map;

    public Solution(int m, int n) {
        M = m;
        N = n;
        CAPACITY = M * N;
        size = CAPACITY;
        random = new Random();
        map = new HashMap<>();
    }

    public int[] flip() {
        if (size <= 0) return new int[] {- 1, - 1};
        int rand = random.nextInt(size);
        size--;
        int idx = map.getOrDefault(rand, rand);
        int tail = map.getOrDefault(size, size);
        map.put(rand, tail);
        return new int[] {idx / N, idx % N};
    }

    public void reset() {
        map = new HashMap<>();
        size = CAPACITY;
    }
}

