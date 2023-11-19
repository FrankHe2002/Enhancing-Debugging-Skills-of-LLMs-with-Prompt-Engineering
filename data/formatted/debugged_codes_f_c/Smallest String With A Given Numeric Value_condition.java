The bug in the provided code is in the loop condition of the first `for` loop. The condition `i > n` should be `i < n`. This is because the loop should iterate as long as `i` is less than `n`, not greater than `n`. 

Additionally, there is an error in the assignment statement `ch[-- n] += currChar`. The `+=` operator is used to concatenate strings, not to increment characters. To increment the current character, we should use `ch[--n] = (char)(ch[n] + currChar)`.

Here is the fixed code:

```java
class Solution {
    public String getSmallestString(int n, int k) {
        char[] ch = new char[n];
        for (int i = 0; i < n; i++) {
            ch[i] = 'a';
            k--;
        }
        int currChar = 0;
        while (k > 0) {
            currChar = Math.min(25, k);
            ch[--n] = (char)(ch[n] + currChar);
            k -= currChar;
        }
        return String.valueOf(ch);
    }
}
```