The bug in the provided code is that the discount percentage is being calculated incorrectly. The discount percentage should be `(100 - discount) / 100` to represent the actual percentage to apply to the total bill.

To fix this, we need to change the calculation in the Cashier constructor from:
```java
this.discount = ((double) 100 - discount) / 100;
```
to:
```java
this.discount = (double)(100 - discount) / 100;
```

Here's the fixed code incorporating the above change:
```java
import java.util.*;

class Cashier {
    private Map<Integer, Integer> catalogue;

    private int n;
    private double discount;
    private int orderNumber;

    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.catalogue = new HashMap<>();

        for (int i = 0; i < prices.length; i++) {
            this.catalogue.put(products[i], prices[i]);
        }

        this.n = n;
        this.discount = (double)(100 - discount) / 100;
        this.orderNumber = 0;
    }

    public double getBill(int[] product, int[] amount) {
        this.orderNumber++;

        double bill = 0.0;
        for (int i = 0; i < amount.length; i++) {
            int p = product[i];
            int price = this.catalogue.get(p);
            bill += price * amount[i];
        }

        if (this.orderNumber % n == 0)
            bill *= this.discount;

        return bill;
    }
}
```