class Solution {

    private int[] prefixSum;
    private Random random;

    public Solution(int[] w) {
        for (int i = 1; i < w.length; i++)
            w[i] += w[i - 1];
        prefixSum = w;
        random = new Random();
    }

    public int pickIndex() {
        int num = 1 + random.nextInt(prefixSum[prefixSum.length - 1]);
        int left = 0;
        int right = prefixSum.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (num <= prefixSum[mid]) {
                if (mid == 0 || num > prefixSum[mid - 1]) {
                    return mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return - 1;
    }
}