// Runtime: 1 ms (Top 42.5%) | Memory: 41.26 MB (Top 39.0%)

class Solution {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int count=0;
        for (int i : hours) { // Fix syntax error: missing semicolon after "for" statement.
            if (i < target) { // Fix logic error: should be "<=" instead of "<".
                count++;
            }
        }
        return count;
    }
}