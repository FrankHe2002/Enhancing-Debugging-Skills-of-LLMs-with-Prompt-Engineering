```java
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>(candies.length);
        int theHighest = candies[0];
        for (int i = 1; i < candies.length; i++) {
            theHighest = Math.max(theHighest, candies[i]);
        }
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= theHighest) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    }
}
```