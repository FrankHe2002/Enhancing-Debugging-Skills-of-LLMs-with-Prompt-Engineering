The issue is with the for loop to copy temp prices to the original price array. It has an error in the condition `i >= n`, which should be `i < n` to correctly iterate over the array. Additionally, the last while loop should be changed to a for loop to decrease k correctly. The fixed code is as follows:

```java
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = Integer.MAX_VALUE;
        }
        prices[src] = 0;

        Map<Integer, List<int[]>> flightsMap = new HashMap<>();
        for (int[] flight : flights) {
            int flightSrc = flight[0];
            int flightDst = flight[1];
            int flightPrice = flight[2];

            List<int[]> flightsList = flightsMap.getOrDefault(flightSrc, new ArrayList<>());
            flightsList.add(new int[] {flightDst, flightPrice});
            flightsMap.put(flightSrc, flightsList);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        for (int i = 0; i <= k; i++) {
            int[] tempPrices = Arrays.copyOf(prices, n);
            int size = q.size();
            for (int j = 0; j < size; j++) {
                int curSrc = q.poll();
                int curPrice = prices[curSrc];
                List<int[]> curFlightsList = flightsMap.getOrDefault(curSrc, new ArrayList<>());
                for (int[] flight : curFlightsList) {
                    int flightDst = flight[0];
                    int flightPrice = flight[1];
                    int newPrice = curPrice + flightPrice;
                    if (newPrice < tempPrices[flightDst]) {
                        tempPrices[flightDst] = newPrice;
                        q.offer(flightDst);
                    }
                }
            }
            prices = Arrays.copyOf(tempPrices, n); // Copy Temp Prices to Original Price Arr
        }
        int totalPrice = prices[dst];
        return totalPrice == Integer.MAX_VALUE ? - 1 : totalPrice;
    }
}
```