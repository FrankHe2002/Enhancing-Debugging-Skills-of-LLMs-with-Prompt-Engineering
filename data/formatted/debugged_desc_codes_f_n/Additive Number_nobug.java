```java
class Solution {

    public boolean isAdditiveNumber(String num) {
        return backtrack(num, 0, 0, 0, 0);
    }

    public boolean backtrack(String num, int idx, long sum, long prev, int length) {
        if (idx == num.length()) {
            return length >= 3;
        }

        long currLong = 0;

        for (int i = idx; i < num.length(); i++) {
            //make sure it won't start with 0
            if (i > idx && num.charAt(idx) == '0') break;
            currLong = currLong * 10 + num.charAt(i) - '0';

            if (length >= 2) {
                if (sum != currLong + prev) {
                    //currLong is not the sum of previous 2 numbers
                    continue;
                }
            }
            //currLong is the sum of previous 2 numbers
            if (backtrack(num, i + 1, currLong, currLong, length + 1) == true) {
                return true;
            }
        }
        return false;
    }
}
```