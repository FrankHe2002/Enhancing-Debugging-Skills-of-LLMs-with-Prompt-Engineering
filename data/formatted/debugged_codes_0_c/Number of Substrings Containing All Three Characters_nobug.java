The provided Java code has a bug. 

The bug is in the while loop inside the if statement. The condition `a > 0 && b > 0 && c > 0` is checking if all three variables are greater than zero, but in each iteration of the loop, only one of the variables is decremented. Therefore, it is not possible for all three variables to become zero, and the while loop will never exit. This causes the program to run indefinitely and eventually result in a timeout.

To fix this bug, we need to update the condition in the while loop to check if any of the variables are greater than zero. If any of the variables are greater than zero, we can continue the loop. Here is the fixed code:

```java
class Solution {
    public int numberOfSubstrings(String s) {
        int a = 0, b = 0, c = 0, count = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'a':
                    ++a;
                    break;
                case 'b':
                    ++b;
                    break;
                case 'c':
                    ++c;
                    break;
            }
            if (a > 0 && b > 0 && c > 0) {
                while (a > 0 || b > 0 || c > 0) { // Change condition to check if any of the variables are greater than zero
                    char farLeft = s.charAt(i - a - b - c + 1);
                    switch (farLeft) {
                        case 'a': {
                            --a;
                            count += doCount(s, i);
                            break;
                        }
                        case 'b': {
                            --b;
                            count += doCount(s, i);
                            break;
                        }
                        case 'c': {
                            --c;
                            count += doCount(s, i);
                            break;
                        }
                    }
                }
            }
        }
        return count;
    }

    private int doCount(String s, int i) {
        int count = 0;
        int n = s.length() - i;
        if (n > 0) {
            count += n;
        }
        return count;
    }
}
```

The fix is to update the condition in the while loop from `a > 0 && b > 0 && c > 0` to `a > 0 || b > 0 || c