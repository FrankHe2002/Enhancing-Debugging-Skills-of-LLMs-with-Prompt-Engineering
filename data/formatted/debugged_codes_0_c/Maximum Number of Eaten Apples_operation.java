The bug in this code is with the PriorityQueue comparator. 

The comparator is defined as `(a, b) -> (a.validDay - b.validDay)`, which subtracts the validDay of 'a' from the validDay of 'b'. However, this can lead to integer overflow if the validDays are large enough. 

To fix this bug, we can use the `Integer.compare()` method instead, which handles integer overflow. 

Here's the fixed code:

```java
import java.util.*;

class Solution {
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<Apple> minHeap = new PriorityQueue<Apple>((a, b) -> Integer.compare(a.validDay, b.validDay));

        //start from day 1
        int currentDay = 1;
        int eatenAppleCount = 0;

        for (int i = 0; i < apples.length; i++) {

            //add apple count and their valid day
            if (apples[i] > 0 && days[i] > 0) {

                //current day is included
                int validDay = currentDay + days[i] - 1;

                minHeap.add(new Apple(apples[i], validDay));
            }


            //check for eatable apple
            while (! minHeap.isEmpty()) {
                //get that apple, with minimum valid date (going to expiry soon)
                Apple apple = minHeap.remove();

                if (apple.validDay >= currentDay) {
                    //eat 1 apple
                    apple.count--;

                    //increment count
                    eatenAppleCount++;

                    //add remaining apple, if not gonna expiry current day
                    if (apple.count > 0 && apple.validDay > currentDay) {
                        minHeap.add(apple);
                    }

                    break;
                }
            }

            //move to the next day
            currentDay++;
        }


        //eat stored apple
        while (! minHeap.isEmpty()) {
            Apple apple = minHeap.remove();

            if (apple.validDay >= currentDay) {
                //eat 1 apple
                apple.count--;

                //increment count
                eatenAppleCount++;

                //add remaining apple, if not gonna expiry current day
                if (apple.count > 0 && apple.validDay > currentDay) {
                    minHeap.add(apple);
                }

                //apple is eaten in current day, now move to next day
                currentDay++;
            }
        }


        return eatenAppleCount;
   