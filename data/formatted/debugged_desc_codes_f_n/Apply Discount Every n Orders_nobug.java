```java
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
        this.discount = ((double) discount) / 100; // fixed the discount calculation
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

        if (this.orderNumber % this.n == 0)  // added "this." prefix to n
            bill -= (this.discount * bill); // fixed the discount calculation

        return bill;
    }
}
```