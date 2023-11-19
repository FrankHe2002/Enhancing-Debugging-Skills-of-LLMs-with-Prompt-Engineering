```java
class Solution {
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<Apple> minHeap = new PriorityQueue<Apple>((a, b) -> a.validDay - b.validDay);

        int currentDay = 1;
        int eatenAppleCount = 0;

        for (int i = 0; i < apples.length; i++) {
            if (apples[i] > 0 && days[i] > 0) {
                int validDay = currentDay + days[i] - 1;
                minHeap.add(new Apple(apples[i], validDay));
            }

            while (!minHeap.isEmpty()) {
                Apple apple = minHeap.peek();

                if (apple.validDay >= currentDay) {
                    apple.count--;
                    eatenAppleCount++;

                    if (apple.count > 0 && apple.validDay > currentDay) {
                        minHeap.add(apple);
                    }

                    if (apple.count == 0 || apple.validDay == currentDay) {
                        minHeap.poll();
                    }

                    break;
                } else {
                    minHeap.poll();
                }
            }

            currentDay++;
        }

        while (!minHeap.isEmpty()) {
            Apple apple = minHeap.peek();

            if (apple.validDay >= currentDay) {
                apple.count--;
                eatenAppleCount++;

                if (apple.count > 0 && apple.validDay > currentDay) {
                    minHeap.add(apple);
                }

                if (apple.count == 0 || apple.validDay == currentDay) {
                    minHeap.poll();
                }

                currentDay++;
            } else {
                minHeap.poll();
            }
        }

        return eatenAppleCount;
    }
}

class Apple {
    int count;
    int validDay;

    public Apple(int count, int validDay) {
        this.count = count;
        this.validDay = validDay;
    }
}
```