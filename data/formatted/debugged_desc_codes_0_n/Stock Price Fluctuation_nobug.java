```java
class StockRecord {
    int timestamp;
    int price;

    public StockRecord() {
    }

    public StockRecord(int t, int p) {
        timestamp = t;
        price = p;
    }
}

class StockPrice {

    PriorityQueue<StockRecord> max = new PriorityQueue<>((sr1, sr2) -> (sr2.price - sr1.price));
    PriorityQueue<StockRecord> min = new PriorityQueue<>((sr1, sr2) -> (sr1.price - sr2.price));
    StockRecord current_record = new StockRecord(0, 0); // Initialize with default timestamp and price
    Map<Integer, Integer> map = new HashMap<>();

    public StockPrice() {
    }

    public void update(int timestamp, int price) {
        if (map.containsKey(timestamp)) {
            int prevPrice = map.get(timestamp);
            map.put(timestamp, price);
            StockRecord prevRecord = new StockRecord(timestamp, prevPrice);
            max.remove(prevRecord);
            min.remove(prevRecord);
        } else {
            map.put(timestamp, price);
        }

        StockRecord newRecord = new StockRecord(timestamp, price);
        max.add(newRecord);
        min.add(newRecord);
        if (timestamp >= current_record.timestamp) {
            current_record.timestamp = timestamp;
            current_record.price = price;
        }
    }

    public int current() {
        return current_record.price;
    }

    public int maximum() {
        while (!max.isEmpty() && map.get(max.peek().timestamp) != max.peek().price) {
            max.poll();
        }
        return max.peek().price;
    }

    public int minimum() {
        while (!min.isEmpty() && map.get(min.peek().timestamp) != min.peek().price) {
            min.poll();
        }
        return min.peek().price;
    }
}
```