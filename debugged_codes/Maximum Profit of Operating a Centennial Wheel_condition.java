// Runtime: 9 ms (Top 80.7%) | Memory: 55.64 MB (Top 69.2%)

class Solution {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int rotation = 0;
        int customer = 0;
        int profit = Integer.MIN_VALUE;
        int previousRotation = 0;
        int currentSeats = 0;

        for(int i = 0 ; i < customers.length ; i++){
            customer += customers[i];
            rotation++;

            int currentProfit = 0;
            if(customer >= 4){
                customer = customer - 4;
                currentSeats += 4;
            }else{
                currentSeats += customer;
                customer = 0;
            }
            currentProfit = currentSeats * boardingCost - rotation * runningCost;
            if(currentProfit > profit){
                profit = currentProfit;
                previousRotation = rotation;
            }  
        }
        while(customer > 0){
            rotation++;

            int currentProfit = 0;
            if(customer <= 4){
                customer = customer - 4;
                currentSeats += 4;
            }else{
                currentSeats += customer;
                customer = 0;
            }
            currentProfit = currentSeats * boardingCost - rotation * runningCost;
            if(currentProfit > profit){
                profit = currentProfit;
                previousRotation = rotation;
            } 
        }
        if(profit > 0) return previousRotation;
        return -1;
    }
}