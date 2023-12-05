```java
// Runtime: 1 ms (Top 88.7%) | Memory: 39.44 MB (Top 55.0%)

class Solution {
    public int minCostSetTime(int startAt, int moveCost, int pushCost, int tar) {

        int min = tar / 60, sec = tar % 60, minCost = (moveCost + pushCost) * 4;

        if (min > 99) {
            min--;
            sec += 60;
        } 

        while (min >= 0 && sec <= 99) { 
            tar = min * 100 + sec;
            String timeString = String.format("%04d", tar);
            int sameMove = 0;
            for (int i = 0; i < timeString.length() - 1; i++)
                if (timeString.charAt(i) == timeString.charAt(i + 1))
                    sameMove++;
            if (startAt == timeString.charAt(0) - '0')
                minCost = Math.min(minCost, pushCost * timeString.length() + moveCost * (timeString.length() - 1 - sameMove));
            else
                minCost = Math.min(minCost, pushCost * timeString.length() + moveCost * (timeString.length() - sameMove));
            min--;
            sec += 60;
        }
        return minCost;
    }
}
```