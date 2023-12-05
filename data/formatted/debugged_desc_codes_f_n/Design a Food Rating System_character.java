```java
class FoodRatings {
    HashMap<String, TreeSet<String>> cuiToFood = new HashMap();
    HashMap<String, Integer> foodToRat = new HashMap();
    HashMap<String, String> foodToCui = new HashMap();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            String food = foods[i];
            String cui = cuisines[i];
            int rating = ratings[i];
            TreeSet<String> foodOfThisCuisine = cuiToFood.getOrDefault(cui, new TreeSet<String>((a, b) -> {
                if (foodToRat.get(a).equals(foodToRat.get(b))) {
                    return a.compareTo(b);
                } else {
                    return foodToRat.get(b) - foodToRat.get(a);
                }
            }));

            foodToRat.put(food, rating);
            foodOfThisCuisine.add(food);
            foodToCui.put(food, cui);

            cuiToFood.put(cui, foodOfThisCuisine);
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