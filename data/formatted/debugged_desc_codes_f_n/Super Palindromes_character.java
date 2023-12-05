```java
// Runtime: 3 ms (Top 92.59%) | Memory: 42.2 MB (Top 79.63%)

import java.util.Arrays;

class Solution {
    public int superpalindromesInRange(String left, String right) {
        int ans = 9 >= Long.parseLong(left) && 9 <= Long.parseLong(right) ? 1 : 0;
        for (long i = 1; i <= 9; i++) {
            long palindrome = getPalindrome(i);
            long superPalindrome = palindrome * palindrome;
            if (superPalindrome >= Long.parseLong(left) && superPalindrome <= Long.parseLong(right) && isPal(Long.toString(superPalindrome))) {
                ans++;
            }
        }
      
        for (int dig = 1; dig < 10; dig++) {
            boolean isOdd = dig % 2 > 0 && dig != 1;
            int innerLen = (dig >> 1) - 1,
                    innerLim = Math.max(1, (int) Math.pow(2, innerLen)),
                    midPos = dig >> 1, midLim = isOdd ? 3 : 1;
            for (int edge = 1; edge < 3; edge++) {
                char[] pal = new char[dig];
                Arrays.fill(pal, '0');
                pal[0] = (char) (edge + 48);
                pal[dig - 1] = (char) (edge + 48);
                if (edge == 2) {
                    innerLim = 1;
                    midLim = Math.min(midLim, 2);
                }
                for (int inner = 0; inner < innerLim; inner++) {
                    if (inner > 0) {
                        String innerStr = Integer.toString(inner, 2);
                        while (innerStr.length() < innerLen)
                            innerStr = "0" + innerStr;
                        for (int i = 0; i < innerLen; i++) {
                            pal[1 + i] = innerStr.charAt(i);
                            pal[dig - 2 - i] = innerStr.charAt(i);
                        }
                    }
                    for (int mid = 0; mid < midLim; mid++) {
                        if (isOdd) pal[midPos] = (char) (mid + 48);
                        String palin = new String(pal);
                        long square = Long.parseLong(palin) * Long.parseLong(palin);
                        if (square > Long.parseLong(right)) return ans;
                        if (square >= Long.parseLong(left) && isPal(Long.toString(square))) ans++;
                    }
                }
            }
        }
        return ans;
    }

    private boolean isPal(String str) {
        for (int i = 0, j = str.length() - 1; i < j; i++, j--)
            if (str.charAt(i) != str.charAt(j)) return false;
        return true;
    }
  
    private long getPalindrome(long num) {
        String str = Long.toString(num);
        String palindrome = str + new StringBuilder(str).reverse().toString();
        return Long.parseLong(palindrome);
    }
}
```