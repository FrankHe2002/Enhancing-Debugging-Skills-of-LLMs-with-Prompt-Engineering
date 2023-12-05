```java
//Runtime: 44 ms (Top 62.29%) | Memory: 74.7 MB (Top 66.20%)
import java.util.Arrays;

class Solution {
    public int maxIceCream(int[] costs, int coins) {
      
        //Greedy Approach
        //a. sort cost in increasing order
        Arrays.sort(costs);
        
        int count = 0;
        for (int cost : costs) {
            
            //b. check remaining coin is greater than or equal to current ice-cream cost
            if (coins - cost >= 0) {
                coins -= cost;
                count++;
            } else {
                break; // break loop if remaining coins can't cover the next ice cream cost
            }
        }
        
        return count;
    }
}
```