```java
class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int count = 2;
        int c1 = capacityA;
        int c2 = capacityB;
        for(int start = 0,end = plants.length - 1; start <= end; start++,end--){
            if(c1 >= plants[start]){
                c1 -= plants[start];
            }else{
                c1 = capacityA - plants[start];
                count++;
            }
            if(c2 >= plants[end]){
                c2 -= plants[end];
            }else{
                c2 = capacityB - plants[end];
                count++;
            }
        }
        if(c1==capacityA){
            count--;
        }
        if(c2==capacityB){
            count--;
        }
        return count;
    }
}
```