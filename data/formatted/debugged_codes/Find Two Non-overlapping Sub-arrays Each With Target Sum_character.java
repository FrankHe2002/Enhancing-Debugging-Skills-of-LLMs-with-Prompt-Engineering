class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        if (arr == null || arr.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, - 1);
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            map.put(sum, i);
        }
        sum = 0;
        int size = arr.length + 1, res = arr.length + 1;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - target)) size = Math.min(size, i - map.get(sum - target));
            if (map.containsKey(sum + target)) res = Math.min(res, size + map.get(sum + target) - i);
        }
        return res == arr.length + 1 ? - 1 : res;
    }
}