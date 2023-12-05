```java
class Solution {
    private int binarySearch(int ans, int x, CustomFunction func) {
        int left = 1, right = 1000;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            int res = func.f(x, mid);

            if (res == ans) {
                List<Integer> temp = new ArrayList<>();
                temp.add(x);
                temp.add(mid);
                return temp;
            }
            if (res < ans) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        List<Integer> temp = new ArrayList<>();
        return temp;
    }

    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 1; i <= 1000; i++) {
            for (int j = 1; j <= 1000; j++) {
                int cmp = customfunction.f(i, j);
                if (cmp == z) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    res.add(temp);
                } else if (cmp > z) {
                    break;
                }
            }
        }
        return res;
    }
}
```