```java
import java.util.PriorityQueue;

class Solution {

    PriorityQueue<Order> buyBackLog;
    PriorityQueue<Order> sellBackLog;

    static int MOD = 1_000_000_007;


    public int getNumberOfBacklogOrders(int[][] orders) {

        //max heap, heapify on price
        buyBackLog = new PriorityQueue<Order>((a, b) -> (b.price - a.price));
        //min heap, heapify on price
        sellBackLog = new PriorityQueue<Order>((a, b) -> (a.price - b.price));


        //handle all orders
        for (int[] order : orders) {
            int price = order[0];
            int quantity = order[1];
            int orderType = order[2];

            if (orderType == 0) {
                //buy order 
                handleBuyOrder(new Order(price, quantity));

            } else if (orderType == 1) {
                //sell order
                handleSellOrder(new Order(price, quantity));
            }
        }

        long counts = 0L;

        //count buy backlog
        while (!buyBackLog.isEmpty()) {
            counts += buyBackLog.remove().quantity;
            counts %= MOD;
        }

        //count sell backlog
        while (!sellBackLog.isEmpty()) {
            counts += sellBackLog.remove().quantity;
            counts %= MOD;
        }


        return (int)(counts % MOD);
    }


    private void handleBuyOrder(Order buyOrder) {
        //just add buy order, if there is no sell back log
        if (sellBackLog.isEmpty()) {
            buyBackLog.add(buyOrder);
            return;
        }


        while (!sellBackLog.isEmpty() && buyOrder.price >= sellBackLog.peek().price && buyOrder.quantity > 0) {
            //sell order with minimum price
            Order sellOrder = sellBackLog.remove();

            if (buyOrder.quantity >= sellOrder.quantity) {
                buyOrder.quantity -= sellOrder.quantity;
                sellOrder.quantity = 0;
            } else {
                //decrement sell order, add remaining sell order
                sellOrder.quantity -= buyOrder.quantity;
                sellBackLog.add(sellOrder);

                buyOrder.quantity = 0;
            }
        }

        //add remaining buy order
        if (buyOrder.quantity > 0) {
            buyBackLog.add(buyOrder);
        }
    }


    private void handleSellOrder(Order sellOrder) {
        //just