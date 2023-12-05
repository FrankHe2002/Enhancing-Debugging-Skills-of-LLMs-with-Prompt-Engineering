The bug in the provided Java code is a syntax error in the if condition inside the else block of the filterRestaurants method. The condition is missing a closing parenthesis ")" after restaurant[4] <= maxDistance.

To fix the bug, simply add the missing closing parenthesis in the if condition inside the else block of the filterRestaurants method.

Here's the corrected code:

```java
// Runtime: 5 ms (Top 93.75%) | Memory: 58 MB (Top 51.88%)
class Restaurant {
    int id, rating;

    Restaurant(int id, int rating) {
        this.id = id;
        this.rating = rating;
    }
}

class RestaurantComparator implements Comparator<Restaurant> {
    @Override
    public int compare(Restaurant r1, Restaurant r2) {
        return r1.rating == r2.rating ? r2.id - r1.id : r2.rating - r1.rating;
    }
}

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