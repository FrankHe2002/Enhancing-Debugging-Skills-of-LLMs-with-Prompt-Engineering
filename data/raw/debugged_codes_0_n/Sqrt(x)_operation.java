// Runtime: 3 ms (Top 6.08%) | Memory: 35.7 MB (Top 53.68%)

class Solution {
    public int mySqrt(int x) {
        long answer = x;
        while (answer * answer > x) {
            answer -= 1;
        }
        return (int)answer;
    }
}