The code is missing a closing parenthesis ')' after the `restaurant[4] <= maxDistance` condition inside the `else` block. 

Fix:
```java
class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        PriorityQueue<Restaurant> heap = new PriorityQueue<>(new RestaurantComparator());
        if (veganFriendly == 1) {
            for (int[] restaurant : restaurants) {
                if (restaurant[2] == 1 && restaurant[3] <= maxPrice && restaurant[4] <= maxDistance) {
                    heap.offer(new Restaurant(restaurant[0], restaurant[1]));
                }
            }
        } else {
            for (int[] restaurant : restaurants) {
                if (restaurant[3] <= maxPrice && restaurant[4] <= maxDistance) {
                    heap.offer(new Restaurant(restaurant[0], restaurant[1]));
                }
            }
        }
        List<Integer> answer = new ArrayList<>();
        while (! heap.isEmpty()) {
            answer.add(heap.poll().id);
        }
        return answer;
    }
}
```