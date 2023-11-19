```java
// Runtime: 1 ms (Top 99.09%) | Memory: 42.9 MB (Top 55.32%)
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>(candies.length); // better practice since the length is known
        int theHighest = candies[0]; //always good practice to start from known value or to check constraints, 0 or -1
        for (int i = 1; i < candies.length; i++) {
            theHighest = Math.max(theHighest, candies[i]); //returns the greatest value for us to compare later
        }
        int mathLogic = theHighest - extraCandies; //fix the math logic by subtracting extraCandies the other side
        for (int i = 0; i < candies.length; i++) {
            //logic: 6+5>=10 or 6 >10-5
            if (candies[i] >= mathLogic) { //change the condition to include cases where candies[i] is equal to mathLogic
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    }
}
```