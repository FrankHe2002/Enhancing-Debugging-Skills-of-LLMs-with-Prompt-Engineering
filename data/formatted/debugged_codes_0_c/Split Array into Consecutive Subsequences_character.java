There is a missing semicolon in the code at line 10. This will result in a compilation error if not fixed. 

To fix the bug, add a semicolon at the end of line 10.

```java
int num = i + 1001;
```

Fixed code:

```java
class Solution {
    public boolean isPossible(int[] nums) {
        int[] freq = new int[2002], subEnd = new int[2002];
        for (int i : nums) {
            int num = i + 1001;
            freq[num]++;
        }
        for (int i : nums) {
            int num = i + 1001;
            if (freq[num] == 0) continue; // Num already in use
            freq[num]--;
            if (subEnd[num - 1] > 0) { // Put into existing subsequence
                subEnd[num - 1]--;
                subEnd[num]++;
            }
            // New subsequence of size 3 is possible
            else if (freq[num + 1] > 0 && freq[num + 2] > 0) {
                freq[num + 1]--;
                freq[num + 2]--;
                subEnd[num + 2]++; // New subsequence
            } else return false;
        }
        return true;
    }
}
```