```java
class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        if (satisfaction[satisfaction.length - 1] <= 0) {
            return 0;
        }

        int res = 0;
        int totalSum = 0;
        int beforeSum = 0;
        for (int i = satisfaction.length - 1; i >= 0; i--) {
            int currNum = satisfaction[i];
            beforeSum += currNum;
            totalSum += beforeSum;
            if (totalSum > res) {
                res = totalSum;
            }
        }

        return res;
    }
}
```