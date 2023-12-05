```java
class Solution {
    public static int largestCombination(int[] candidates) {
        int arr[] = new int[32];
        for (int i = 0; i < candidates.length; i++) {
            String temp = Integer.toBinaryString(candidates[i]);
            int n = temp.length();
            int index = 0;
            while (n-- > 0) {
                arr[31 - index++] += temp.charAt(n) - '0';
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (arr[i] > 0) {
                res += (1 << (31 - i));
            }
        }
        return res;
    }
}
```