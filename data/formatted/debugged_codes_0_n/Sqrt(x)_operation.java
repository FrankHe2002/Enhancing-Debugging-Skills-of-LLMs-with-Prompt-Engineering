class Solution {
    public int mySqrt(int x) {
        long answer = x;
        while (answer * answer > x) {
            answer -= 1;
        }
        return (int) answer;
    }
}