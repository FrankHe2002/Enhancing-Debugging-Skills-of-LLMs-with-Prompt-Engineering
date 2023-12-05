```java
class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        Map<String, List<Transaction>> nameToTransaction = new HashMap<>();
        for (int i = 0; i < transactions.length; i++) {
            Transaction t = new Transaction(transactions[i], i);
            nameToTransaction.putIfAbsent(t.name, new ArrayList<>());
            nameToTransaction.get(t.name).add(t);
        }
        List<String> invalid = new ArrayList<>();
        for (List<Transaction> list : nameToTransaction.values()) {
            for (Transaction t : list) {
                if (t.isInvalidAmount() || t.isInvalidCity(list)) invalid.add(transactions[t.id]);
            }
        }
        return invalid;
    }
}

class Transaction {
    String name, city;
    int time, amount, id;

    Transaction(String s, int id) {
        this.id = id;
        String[] split = s.split(",");
        name = split[0];
        time = Integer.parseInt(split[1]);
        amount = Integer.parseInt(split[2]);
        city = split[3];
    }

    boolean isInvalidAmount() {
        return this.amount > 1000;
    }

    boolean isInvalidCity(List<Transaction> list) {
        for (Transaction t : list) {
            if (!city.equals(t.city) && Math.abs(t.time - time) <= 60) {
                return true;
            }
        }
        return false;
    }
}
```