```java
class Solution {
    public int minCostSetTime(int startAt, int moveCost, int pushCost, int tar) {

        int min = tar / 60, sec = tar % 60, minCost = (moveCost + pushCost) * 4;

        if (min > 99) {
            min = 99; // Change to set the maximum value for the minutes
            sec = 99; // Change to set the maximum value for the seconds
        } 

        while (min >= 0 && sec <= 99) { 
            tar = min * 100 + sec;
            String arr = String.format("%04d", tar); // Change to format the string with 4 digits
            int sameMove = 0;
            for (int i = 0; i < arr.length() - 1; i++)
                if (arr.charAt(i) == arr.charAt(i + 1))
                    sameMove++;
            if (startAt == arr.charAt(0) - '0')
                minCost = Math.min(minCost, pushCost * arr.length() + moveCost * (arr.length() - 1 - sameMove)); // Change to get the length of string
            else
                minCost = Math.min(minCost, pushCost * arr.length() + moveCost * (arr.length() - sameMove)); // Change to get the length of string
            min--;
            sec += 60;
        }
        return minCost;
    }
}
```