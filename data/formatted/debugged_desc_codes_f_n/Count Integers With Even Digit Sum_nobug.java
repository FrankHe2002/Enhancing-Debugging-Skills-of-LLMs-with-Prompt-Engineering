```java
class Solution {
    public int countEven(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++)
            if (isEven(sumDig(i)))  // Updated to use the isEven method
                count++;
        return count;
    }

    private boolean isEven(int n) {  // Renamed method to isEven
        return (n & 1) == 0;  // Simplified the return statement
    }

    // Removed the redundant ternary operator
    private int sumDig(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
```