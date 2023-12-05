```java
class Solution {
    public int minSteps(int n) {
        int rem = n, copied = 0, ans = 0, onScreen = 1;

        while (rem > 1) {
            if (rem % onScreen == 0) {
                copied = onScreen;
                ans += onScreen;
            }
            rem -= copied;
            ans++;
            onScreen = rem; 
        }

        return ans;
    }
}
```