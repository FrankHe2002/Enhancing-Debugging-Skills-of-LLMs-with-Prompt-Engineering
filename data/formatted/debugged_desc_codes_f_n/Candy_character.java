```java
// Runtime: 16 ms (Top 14.09%) | Memory: 53.1 MB (Top 8.48%)
class Solution {
    public int candy(int[] ratings) {

        int[] left = new int[ratings.length];
        Arrays.fill(left, 1);

        for (int i = 0; i < ratings.length - 1; i++) {
            if (ratings[i] < ratings[i + 1])
                left[i + 1] = left[i] + 1;
        }

        int[] right = new int[ratings.length];
        Arrays.fill(right, 1);

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i + 1] < ratings[i] && right[i] <= right[i + 1]) // Added missing parentheses
                right[i] = right[i + 1] + 1;
        }
        int sum = 0;
        for (int i = 0; i < right.length; i++) {
            sum += Math.max(right[i], left[i]);
        }

        return sum;
    }
}
```