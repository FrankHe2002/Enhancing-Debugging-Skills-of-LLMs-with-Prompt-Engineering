```java
// Runtime: 107 ms (Top 27.4%) | Memory: 53.91 MB (Top 31.3%)

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String kthLargestNumber(String[] nums, int k) {

        int n = nums.length;

        Arrays.sort(nums, new Comparator<String>() {
            public int compare(String a, String b) {
                if (a.length() > b.length()) return 1;
                else if (b.length() > a.length()) return - 1;
                else {
                    return isGreater(a, b);
                }
            }
        });
        return nums[n - k];
    }

    public static int isGreater(String a, String b) {

        int n = a.length();

        for (int i = 0; i < n; i++) {
            int a1 = Integer.parseInt("" + a.charAt(i));
            int b1 = Integer.parseInt("" + b.charAt(i));
            if (a1 > b1) return 1;
            if (b1 > a1) return - 1;
        }
        return 0;
    }
}
```