class Solution {

    List<Integer> res = new ArrayList<>();

    public int[] numsSameConsecDiff(int n, int k) {

        for (int ans = 1; ans < 10; ans++) {
            find(ans, n - 1, k);
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private void find(int ans, int n, int k) {

        if (n == 0) {
            res.add(ans);
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (Math.abs(ans % 10 - i) != k)
                find(ans * 10 + i, n - 1, k);
        }
        ans /= 10;
    }
}