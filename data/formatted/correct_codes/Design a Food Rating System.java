class FoodRatings {
    HashMap<String, TreeSet<String>> cuiToFood = new HashMap();
    HashMap<String, Integer> foodToRat = new HashMap();
    HashMap<String, String> foodToCui = new HashMap();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            TreeSet<String> foodOfThisCuisine = cuiToFood.getOrDefault(cuisines[i], new TreeSet<String>((a, b) ->
                    foodToRat.get(a).equals(foodToRat.get(b)) ? a.compareTo(b) : foodToRat.get(b) - foodToRat.get(a)));

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
