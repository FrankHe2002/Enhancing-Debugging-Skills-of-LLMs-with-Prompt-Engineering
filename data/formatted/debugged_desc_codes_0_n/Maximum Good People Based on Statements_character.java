```java
// Runtime: 1 ms (Top 98.48%) | Memory: 42.5 MB (Top 63.64%)
class Solution {
    public int maximumGood(int[][] statements) {
        int[] result = {0};
        maximumGood(statements, new boolean[statements.length], 0, 0, result);
        return result[0];
    }

    private void maximumGood(int[][] statements, boolean[] goodPeople, int currentPerson, int currentGoodPeople, int[] result) {
        if (currentPerson == goodPeople.length) {
            result[0] = Math.max(result[0], currentGoodPeople);
            return;
        }

        goodPeople[currentPerson] = true;
        if (goodPeople.length - currentPerson + currentGoodPeople < result[0]) {
            return;
        }
        if (isValid(statements, goodPeople, currentPerson)) {
            maximumGood(statements, goodPeople, currentPerson + 1, currentGoodPeople + 1, result);
        }

        goodPeople[currentPerson] = false;
        if (goodPeople.length - currentPerson - 1 + currentGoodPeople < result[0]) {
            return;
        }
        if (isValid(statements, goodPeople, currentPerson)) {
            maximumGood(statements, goodPeople, currentPerson + 1, currentGoodPeople, result);
        }

        return;
    }

    private boolean isValid(int[][] statements, boolean[] goodPeople, int currentPerson) {
        for (int i = 0; i < currentPerson; ++i) {
            if (goodPeople[i]) {
                if (goodPeople[currentPerson] && statements[i][currentPerson] == 0) {
                    return false;
                }
                if (!goodPeople[currentPerson] && statements[i][currentPerson] == 1) {
                    return false;
                }
            }
        }

        if (goodPeople[currentPerson]) {
            for (int i = 0; i < currentPerson; ++i) {
                if (goodPeople[i] && statements[currentPerson][i] == 0) return false;
                if (!goodPeople[i] && statements[currentPerson][i] == 1) return false;
            }
        }

        return true;
    }
}
```