The bug type in the provided Buggy Java code is logical error and syntax error. 

The logical error can be found when making checks inside every method. It is a logical error because it causes the method to perform incorrectly, providing incorrect results.

The syntax error can be found in the missing semicolons at the end of the statement inside a loop. It is a syntax error as per Java syntax guidelines.

Fix:
```java
import java.util.HashMap;
import java.util.TreeSet;

class FoodRatings {
    HashMap<String, TreeSet<String>> cuiToFood = new HashMap<>();
    HashMap<String, Integer> foodToRat = new HashMap<>();
    HashMap<String, String> foodToCui = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            TreeSet<String> foodOfThisCuisine = cuiToFood.getOrDefault(cuisines[i], new TreeSet<String>((a, b) -> {
                if (foodToRat.get(b).equals(foodToRat.get(a))) {
                    return a.compareTo(b);
                } else {
                    return foodToRat.get(b) - foodToRat.get(a);
                }
            }));

            foodToRat.put(foods[i], ratings[i]);
            foodOfThisCuisine.add(foods[i]);
            foodToCui.put(foods[i], cuisines[i]);

            cuiToFood.put(cuisines[i], foodOfThisCuisine);
        }
    }

    public void changeRating(String food, int newRating) {
        String cui = foodToCui.get(food);
        TreeSet<String> foodOfThisCui = cuiToFood.get(cui);
        foodOfThisCui.remove(food);
        foodToRat.put(food, newRating);

        foodOfThisCui.add(food);
        cuiToFood.put(cui, foodOfThisCui);
    }

    public String highestRated(String cuisine) {
        return cuiToFood.get(cuisine).first();
    }
}
```
