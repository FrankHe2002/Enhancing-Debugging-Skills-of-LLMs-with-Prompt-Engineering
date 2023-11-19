```java
class Solution {
    public int binaryGap(int n) {
        String binaryString = Integer.toBinaryString(n);
        int res = 0;
        int prevIndex = -1;
        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1') {
                if (prevIndex != -1) {
                    res = Math.max(res, i - prevIndex);
                }
                prevIndex = i;
            }
        }
        return res;
    }
}
```