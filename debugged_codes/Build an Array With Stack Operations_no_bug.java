class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        int i = 1, j = 0;
        while (j < target.length) {
            result.add("Push");
            if (i == target[j]) {
                j++;
            }
            i++;
        }
        for (; i <= n; i++) {
            result.add("Pop");
        }
        return result;
    }
}