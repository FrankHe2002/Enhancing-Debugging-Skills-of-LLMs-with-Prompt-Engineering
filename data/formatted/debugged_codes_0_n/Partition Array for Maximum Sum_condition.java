```java
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        return maxSum(arr, k, 0);
    }

    public int maxSum(int[] arr, int k, int start) {
        int curr1 = 0, curr2 = 0;
        int prev = 0;
        int max = 0;

        Map<String, Integer> memo = new HashMap<>();

        for (int i = 0; i < arr.length; ++ i) {
            curr1 = prev + arr[i];

            int tempk = 0, half1 = 0, half2 = 0, temp = 0;
            for (int p = 0; p <= k; ++ p) {
                half1 = findMaxSumWithKEle(arr, p, i);
                tempk = i - p;
                half2 = memo.getOrDefault("0," + tempk, 0);
                if (temp < half1 + half2) {
                    temp = half1 + half2;
                }
            }

            curr2 = temp;

            max = Math.max(curr1, curr2);

            String key = "0," + i;
            memo.put(key, max);
            System.out.println("Max: " + max + " from [" + key + "]");
            prev = max;
        }

        return max;
    }

    public static int findMaxSumWithKEle(int[] arr, int k, int end) {
        int max = 0;
        if (end >= arr.length || end < 0) {
            return 0;
        }
        int c = 0;
        for (int i = end; i > (end - k) && i >= 0; -- i) {
            ++ c;
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max * c;
    }
}
```
```