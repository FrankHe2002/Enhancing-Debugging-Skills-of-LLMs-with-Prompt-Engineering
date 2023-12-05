```java
class Solution {

    // Approach: Use hashmap to count frequency and used array to keep track of sold quantities
    // Check if totals of sold quantities meet the total oredered or not.
    public boolean canDistribute(int[] nums, int[] quantity) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums)
            freq.put(num, freq.getOrDefault(num, 0) + 1);

        int[] sold = new int[freq.size()];
        int idx = 0;
        for (int f : freq.values())
            sold[idx++] = f;

        Arrays.sort(quantity);
        return rec(sold, quantity, quantity.length - 1);
    }

    private boolean rec(int[] sold, int[] quantity, int j) {
        if (j == - 1)
            return true;

        for (int i = 0; i < sold.length; ++i) {
            if (sold[i] >= quantity[j]) {
                sold[i] -= quantity[j];
                if (rec(sold, quantity, j - 1))
                    return true;
                sold[i] += quantity[j];
            }
        }
        return false;
    }
}
```