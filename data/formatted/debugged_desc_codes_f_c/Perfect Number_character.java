Fix:
```java
// Runtime: 3 ms (Top 51.95%) | Memory: 40.9 MB (Top 44.38%)
class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num == 1)
            return false;

        int sum = 1;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                if (i != num/i) {
                    sum += i + num / i;
                } else {
                    sum += i;
                }
            }
        }
        return sum == num;
    }
}
```