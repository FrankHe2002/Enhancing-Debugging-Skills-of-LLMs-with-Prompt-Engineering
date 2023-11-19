class Solution {
    int bobPoint = 0;
    int[] maxbob = new int[12];

    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        int[] bob = new int[12];
        calculate(aliceArrows, bob, 11, numArrows, 0);
        return maxbob;
    }

    public void calculate(int[] alice, int[] bob, int index, int remainArr, int point) {
        if (index < 0 || remainArr <= 0) {
            if (remainArr > 0)
                bob[0] += remainArr;
            if (point > bobPoint) {
                bobPoint = point;
                maxbob = bob.clone();
            }
            return;
        }
        if (remainArr >= alice[index] + 1) {
            bob[index] = alice[index] + 1;
            calculate(alice, bob, index - 1, remainArr - (alice[index] + 1), point + index);
            bob[index] = 0;
        }
        calculate(alice, bob, index - 1, remainArr, point);
        bob[index] = 0;
    }
}