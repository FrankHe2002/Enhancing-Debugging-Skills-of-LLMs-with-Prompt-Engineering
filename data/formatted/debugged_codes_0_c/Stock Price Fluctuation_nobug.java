Bug type: Uninitialized variable bug

Reasoning process:
1. Review the code and identify any uninitialized variables.
2. In the `StockPrice` class, there is an uninitialized variable `current_record` of type `StockRecord`.
3. This variable is assigned a value of `null` by default, but it is later accessed in the `update` method and in the `current` method.
4. This can lead to a NullPointerException if the `current_record` variable is not properly initialized before it is accessed.

Fix:
1. Initialize the `current_record` variable in the constructor of the `StockPrice` class.

```java
public StockPrice() {
    current_record = new StockRecord(0, 0); // Initialize current_record with default values
}
```

Updated code:

```java
import java.util.*;

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
    StockRecord current_record;
    Map<Integer, Integer> map = new HashMap<>();


    public StockPrice() {
        current_record = new StockRecord(0, 0); // Initialize current_record with default values
    }

    public void update(int timestamp, int price) {
        if (timestamp >= current_record.timestamp) {
            current_record.timestamp = timestamp;
            current_record.price = price;
        }

        StockRecord sr = new StockRecord(timestamp, price);
        max.add(sr);
        min.add(sr);
        map.put(timestamp, price);
    }

    public int current() {
        return current_record.price;
    }

    public int maximum() {
        StockRecord sp = max.peek();
        while (true) {
            sp = max.peek();
            if (sp.price != map.get(sp.timestamp))
                max.poll();
            else break;
        }
        return sp.price;
    }

    public int minimum() {
        StockRecord sp = min.peek();
        while (true) {
            sp = min.peek();
            if (sp.price != map.get(sp.timestamp))
                min.poll();
            else break;
        }
        return sp.price;
    }
}
