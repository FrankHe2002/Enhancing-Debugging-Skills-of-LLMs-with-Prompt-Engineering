The provided Java code has a bug. 

The bug is in the line `if ((arr[i + 1] & 1) > 0)`. 

Let's analyze the code step by step to identify and fix the bug:

1. The code initializes `count` to 0 and `n` to the length of the array `arr`.

2. It then starts a loop from index 0 to index `n-1`.

3. Inside the loop, it checks if the number at `arr[i + 1]` is odd by performing a bitwise AND operation `&` with 1. If the result is greater than 0, it means the number is odd. In that case, it increments `count` by 1.

4. After incrementing `count`, it checks if `count` is equal to 3. If it is, it returns `true`.

5. If the number at `arr[i + 1]` is even, the code sets `count` back to 0.

6. Finally, if the loop completes without finding three consecutive odd numbers, it returns `false`.

The bug in the code is that it tries to access `arr[i + 1]` inside the loop, which could cause an `ArrayIndexOutOfBoundsException`. This happens because the loop runs from index 0 to index `n-1`, but `arr[i + 1]` accesses the next element. So, when `i` is equal to `n-1`, `arr[i + 1]` tries to access the element at index `n` which is out of bounds.

To fix this bug, we need to modify the loop condition from `i < n` to `i < n-1`. This will ensure that `arr[i + 1]` does not go out of bounds. Additionally, we should also initialize `count` to 1 instead of 0 to account for the first odd number encountered.

Here is the corrected code:

```java
class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 1, n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            if ((arr[i + 1] & 1) > 0) {
                count++;
                if (count == 3) return true;
            } else {
                count = 0;
            }
        }
        return false;
    }
}
