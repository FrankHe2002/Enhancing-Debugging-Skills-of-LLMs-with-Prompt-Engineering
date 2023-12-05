```java
class Solution {

    public int getXORSum(int[] arr1, int[] arr2) {
        int xorSumX = 0;
        for (int xi : arr1) {
            xorSumX ^= xi;
        }
        int answer = 0;
        for (int xj : arr2) {
            answer ^= (xj & xorSumX);
        }
        return answer;
    }

}
```