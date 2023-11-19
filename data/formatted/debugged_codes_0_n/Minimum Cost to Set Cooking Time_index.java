class Solution {
    public int minCostSetTime(int startAt, int moveCost, int pushCost, int tar) {
        int min = tar / 60;
        int sec = tar % 60;
        int minCost = (moveCost + pushCost) * 4;

        if (min > 99) {
            min--;
            sec += 60;
        }

        while (min >= 0 && sec <= 99) {
            tar = min * 100 + sec;
            char arr[] = ("" + tar).toCharArray();
            int sameMove = 0;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] == arr[i + 1]) {
                    sameMove++;
                }
            }
            if (startAt == arr[arr.length - 2] - '0') {
                minCost = Math.min(minCost, pushCost * arr.length + moveCost * (arr.length - 1 - sameMove));
            } else {
                minCost = Math.min(minCost, pushCost * arr.length + moveCost * (arr.length - sameMove));
            }
            min--;
            sec += 60;
        }
        return minCost;
    }
}