```java
class Solution {
    public int minDeletionSize(String[] strs) {
        boolean[] sorted = new boolean[strs.length];
        int res = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            int j = 0;
            for (; j < strs.length - 1; j++) {
                if (!sorted[j] && strs[j].charAt(i) > strs[j + 1].charAt(i)) {
                    res++;
                    for (int k = 0; k < strs.length; k++) {
                        if (!sorted[k]) {
                            if (strs[k].charAt(i) > strs[j + 1].charAt(i)) {
                                sorted[k] = true;
                            }
                        }
                    }
                    break;
                }
            }
        }
        return res;
    }
}
```