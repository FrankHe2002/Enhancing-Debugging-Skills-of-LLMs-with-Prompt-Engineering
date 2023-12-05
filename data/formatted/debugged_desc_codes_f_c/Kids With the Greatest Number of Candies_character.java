```java
// Runtime: 1 ms (Top 99.09%) | Memory: 42.9 MB (Top 55.32%)
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>(candies.length); // better practice since the length is known
        int theHighest = 0;
        for (int candy : candies) {
            theHighest = Math.max(theHighest, candy); //returns the greatest value for us to compare later
        }
        //Since we are comparing with the greatest value, we can use math logic to subtract extraCandies the other side
        //(candies[i]+extraCandies >= theHighest) or (candies[i] >= theHighest-extraCandies)
        int mathLogic = theHighest - extraCandies;
        for (int candy : candies) {
            //logic: 6+5>=10 or 6 >=10-5
            result.add(candy >= mathLogic);
        }
        return result;
    }
}
```