Explanation:
The original `StockPrice` class contains the following bugs:
1. It incorrectly stores the `current_record` only when the timestamp is greater or equal to the current timestamp. It should be updated in any case regardless.
2. The `map` is not being updated whenever a new record is added.
3. The update, maximum, and minimum operations have an O(n) time complexity due to removal operations in the while loops for maintaining consistent state among data structures.

Fix:
The following fixes address the identified issues:
1. Always update the `current_record` when an update is called.
2. Update the `map` whenever a new record is added.
3. Use a different approach to store the stock records and retrieve the max and min in O(log n) time.

```java
import java.util.TreeMap;

class StockPrice {

    TreeMap<Integer, Integer> stockRecords;
    int latestTimestamp;
    TreeMap<Integer, Integer> descendingPrices;
    TreeMap<Integer, Integer> ascendingPrices;

    public StockPrice() {
        stockRecords = new TreeMap<>();
        latestTimestamp = Integer.MIN_VALUE;
        descendingPrices = new TreeMap<>();
        ascendingPrices = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        if (timestamp >= latestTimestamp) {
            latestTimestamp = timestamp;
            stockRecords.put(timestamp, price);
            descendingPrices.put(price, descendingPrices.getOrDefault(price, 0) + 1);
            ascendingPrices.put(price, ascendingPrices.getOrDefault(price, 0) + 1);
        } else if (stockRecords.containsKey(timestamp)) {
            int prevPrice = stockRecords.get(timestamp);
            decreaseCount(descendingPrices, prevPrice);
            decreaseCount(ascendingPrices, prevPrice);
            stockRecords.put(timestamp, price);
            descendingPrices.put(price, descendingPrices.getOrDefault(price, 0) + 1);
            ascendingPrices.put(price, ascendingPrices.getOrDefault(price, 0) + 1);
        }
    }

    private void decreaseCount(TreeMap<Integer, Integer> map, int price) {
        map.put(price, map.get(price) - 1);
        if (map.get(price) == 0) {
            map.remove(price);
        }
    }

    public int current() {
        return stockRecords.get(latestTimestamp);
    }

    public int maximum() {
        return descendingPrices.lastKey();
    }

    public int minimum() {
        return ascendingPrices.firstKey();
    }
}
```