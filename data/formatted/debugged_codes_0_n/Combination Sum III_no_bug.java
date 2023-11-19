class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> ds = new ArrayList<>();
        helper(1, n, k, ds, ans);
        return ans;
    }

    private static void helper(int i, int tar, int k, List<Integer> ds, List<List<Integer>> ans) {
        if (k == 0 && tar == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        if (k == 0 || tar == 0) return;
        if (i > tar || i > 9) return;
        ds.add(i);
        helper(i + 1, tar - i, k - 1, ds, ans);
        ds.remove(ds.size() - 1);
        helper(i + 1, tar, k, ds, ans);
    }
}