class Solution {
    private int mod = 1000000007;

    private Integer stepCount[][][][] = null;

    public int countSteppingNumbers(String low, String high) {
        stepCount = new Integer[101][2][2][10];
        int left = countStepNums(low, 0, 1, 1, 0);

        stepCount = new Integer[101][2][2][10];
        int right = countStepNums(high, 0, 1, 1, 0);

        int answer = (right % mod - left % mod + mod) % mod;

        boolean incLow = true;
        for (int indx = 0; indx < low.length(); indx++) {
            if (indx != 0 && Math.abs(low.charAt(indx) - low.charAt(indx - 1)) != 1) incLow = false;
        }
        if (incLow) answer = (answer + 1) % mod;

        return (int) answer;
    }

    private int countStepNums(String numStr, int numIndx, int isBounded,
                              int arePrevZeroes, int prevDigs) {
        if (numIndx == (int) numStr.length()) {
            return (arePrevZeroes == 1) ? 0 : 1;
        }

        if (stepCount[numIndx][isBounded][arePrevZeroes][prevDigs] != null)
            return stepCount[numIndx][isBounded][arePrevZeroes][prevDigs];

        int answer = 0, willBeZero = - 1, newisBounded = - 1;
        int limit = (isBounded == 1) ? (numStr.charAt(numIndx) - '0') : 9;

        for (int dig = 0; dig <= limit; dig++) {
            willBeZero = (arePrevZeroes == 1 && dig == 0) ? 1 : 0;
            newisBounded = (isBounded == 1 && dig == limit) ? 1 : 0;

            if (arePrevZeroes == 1 || Math.abs(dig - prevDigs) == 1) {
                answer = (answer % mod + countStepNums(numStr, numIndx + 1, newisBounded, willBeZero, dig) % mod) % mod;
            }
        }

        stepCount[numIndx][isBounded][arePrevZeroes][prevDigs] = answer;
        return answer;
    }

}