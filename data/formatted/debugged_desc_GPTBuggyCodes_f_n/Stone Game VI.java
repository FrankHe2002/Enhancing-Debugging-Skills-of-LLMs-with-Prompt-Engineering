```java
class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = aliceValues[i] + bobValues[i];
        }
        Arrays.sort(a);
        int sumAlice = 0;
        int sumBob = 0;
        for (int i = n - 1; i >= 0; i -= 2) {
            sumAlice += aliceValues[i];
        }
        for (int i = n - 2; i >= 0; i -= 2) {
            sumBob += bobValues[i];
        }
        return Integer.compare(sumAlice, sumBob);
    }
}
```