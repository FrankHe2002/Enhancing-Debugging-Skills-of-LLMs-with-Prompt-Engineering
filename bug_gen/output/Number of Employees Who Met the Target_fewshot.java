// Runtime: 1 ms (Top 42.5%) | Memory: 41.26 MB (Top 39.0%)

class Solution {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        return (int) Arrays.stream(hours).filter((i) -> i < target).count();
    }
}