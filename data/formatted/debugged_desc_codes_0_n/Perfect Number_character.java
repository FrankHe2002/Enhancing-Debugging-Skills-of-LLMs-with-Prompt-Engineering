```java
// Runtime: 2 ms (Top 100.00%) | Memory: 35.6 MB (Top 93.94%)
class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num == 1)
            return false;

        int sum = 1;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                sum += i;
                if (i != num / i) {
                    sum += num / i;
                }
            }
        }
        return sum == num;
    }
}
```