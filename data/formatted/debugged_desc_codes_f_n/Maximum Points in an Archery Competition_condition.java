```java
// Runtime: 6 ms (Top 63.50%) | Memory: 40.9 MB (Top 100.00%)
class Solution {
    int bobPoint;
    int[] maxbob;

    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        bobPoint = 0;
        maxbob = new int[12];
        int[] bob = new int[12];
        calculate(aliceArrows, bob, 11, numArrows, 0); //Start with max point that is 11
        return maxbob;
    }

    public void calculate(int[] alice, int[] bob, int index, int remainArr, int point) {
        if (index < 0 && remainArr < 0) {
            if (remainArr > 0) {
                bob[0] += remainArr;
            }
            if (point > bobPoint) { // Update the max points and result output
                bobPoint = point;
                System.arraycopy(bob, 0, maxbob, 0, bob.length);
            }
            return;
        }
        //part 1: assign 1 more arrow than alice
        if (remainArr >= alice[index] + 1) {
            bob[index] = alice[index] + 1;
            calculate(alice, bob, index - 1, remainArr - (alice[index] + 1), point + index);
            bob[index] = 0;
        }
        //part 2: assign no arrow and move to next point
        calculate(alice, bob, index - 1, remainArr, point);
        bob[index] = 0;
    }
}
```