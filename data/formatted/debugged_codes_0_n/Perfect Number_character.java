```java
// Runtime: 3 ms (Top 51.95%) | Memory: 40.9 MB (Top 44.38%)
class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num == 1)
            return false;

        int sum = 1;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                sum += i + num / i;
            }
        }
        return sum == num;
    }
}
```