```java
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;

        while (left <= right) {
            int mid = ((right - left) / 2) + left;
            int result = guess(mid);
            if (result == 0)
                return mid;
            else if (result < 0)
                right = mid - 1;
            else
                left = mid + 1; // fixed the subtle bug introduced here (changed left = mid; to left = mid + 1;)
        }

        return -1; // fixed the missing return statement when the number is not found
    }
}
```