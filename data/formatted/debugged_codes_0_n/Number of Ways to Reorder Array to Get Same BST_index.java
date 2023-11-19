class Solution {
    long[][] pascal;
    private static final long mod = 1000000007;
    long one = 1;

    public int numOfWays(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int n : nums) {
            list.add(n);
        }
        formPascal(nums);
        return (int) dfs(list) - 1;
    }

    public long dfs(ArrayList<Integer> list) {
        if (list.size() <= 2)
            return 1;
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        int root = list.get(0);

        for (int n : list) {
            if (n < root)
                left.add(n);
            else if (n > root)
                right.add(n);
        }

        return ((pascal[left.size() + right.size()][left.size()] % mod) * (dfs(left) % mod) * (dfs(right) % mod)) % mod;
    }

    private void formPascal(int[] nums) {
        pascal = new long[nums.length + 1][];

        for (int i = 0; i <= nums.length; i++) {
            pascal[i] = new long[i + 1];
            Arrays.fill(pascal[i], one);
        }
    }
}